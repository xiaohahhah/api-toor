package cn.nmmpa.aop.formvalidation;

import cn.nmmpa.aop.util.KeyUtil;
import cn.nmmpa.common.util.IPUtil;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.redis.util.RedisService;
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
 * @Date: 2019/8/1 14:53
 * @Version 1.0
 */
@Component
@Aspect
public class RequestLimitAop {

    @Autowired
    private RedisService redisService;

    @Around("@annotation(cn.nmmpa.aop.formvalidation.RequestLimit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String key = KeyUtil.getKey(request , method , joinPoint.getArgs());
        RequestLimit avoidRepeatableCommit =  method.getAnnotation(RequestLimit.class);
        boolean res = redisService.limit(key , avoidRepeatableCommit.limitNum() , avoidRepeatableCommit.time());
        if(!res){
            throw new RequestLimitException(500 , "操作频繁，请稍后再试!");
        }
        return joinPoint.proceed();
    }
}
