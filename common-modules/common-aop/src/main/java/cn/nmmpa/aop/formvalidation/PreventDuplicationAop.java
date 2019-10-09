package cn.nmmpa.aop.formvalidation;

import cn.nmmpa.aop.util.KeyUtil;
import cn.nmmpa.common.util.IPUtil;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.redis.util.RedisService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Author: tan shuai
 * @Date: 2019/7/22 17:19
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class PreventDuplicationAop {

    @Autowired
    private RedisService redisService;

    @Around("@annotation(cn.nmmpa.aop.formvalidation.AvoidRepeatableCommit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String strKey = UUID.randomUUID().toString().replace("-" , "");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String key = KeyUtil.getKey(request , method , joinPoint.getArgs());
        AvoidRepeatableCommit avoidRepeatableCommit =  method.getAnnotation(AvoidRepeatableCommit.class);
        int timeout = avoidRepeatableCommit.timeout();
        if(timeout == 0){
            return joinPoint.proceed();
        }
        boolean lockIsSuccess = redisService.preventDuplication(key , strKey , timeout);
        if(lockIsSuccess){
            try {
                return joinPoint.proceed();
            }catch (Throwable e){
                redisService.delLock(key , strKey);
                throw e;
            }
        }else {
            throw new FormValidationException(500 , "操作频繁，请稍后再试!");
        }

    }
}
