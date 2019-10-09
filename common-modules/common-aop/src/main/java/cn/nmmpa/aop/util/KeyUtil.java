package cn.nmmpa.aop.util;

import cn.nmmpa.common.util.IPUtil;
import cn.nmmpa.common.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author: tan shuai
 * @Date: 2019/8/1 15:08
 * @Version 1.0
 */
public class KeyUtil {

    public static String getKey(HttpServletRequest request , Method method , Object[] params) throws IOException {
        String ip = IPUtil.getIP(request);
        //目标类、方法
        String className = method.getDeclaringClass().getName();
        String name = method.getName();
        StringBuilder key = new StringBuilder(ip).append(":").append(className).append(".").append(name).append(":");
        for(Object obj : params){
            key.append(obj);
        }
        return MD5Util.MD5(key.toString());
    }
}
