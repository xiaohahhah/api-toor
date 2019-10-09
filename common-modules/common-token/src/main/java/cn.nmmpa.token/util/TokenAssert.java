package cn.nmmpa.token.util;

import cn.nmmpa.token.exception.TokenException;
import cn.nmmpa.token.vo.BaseBody;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/26 10:41
 * @Version 1.0
 */
public class TokenAssert {

    public static void isNotNull(String p , String msg){
        if(p == null || "".equals(p)){
            throw new TokenException(msg);
        }
    }

    public static void isNotNull(Map p , String msg){
        if(p == null){
            throw new TokenException(msg);
        }
    }

    public static void isNotNull(BaseBody p , String msg){
        if(p == null){
            throw new TokenException(msg);
        }
    }
}
