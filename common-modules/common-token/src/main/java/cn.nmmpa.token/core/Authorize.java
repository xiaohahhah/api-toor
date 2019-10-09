package cn.nmmpa.token.core;

import cn.nmmpa.token.exception.TokenException;
import cn.nmmpa.token.util.TokenAssert;
import cn.nmmpa.token.vo.BaseBody;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 15:30
 * @Version 1.0
 */
public class Authorize {

    private ITokenService tokenService;

    private ITokenCache tokenCache;

    /**
     * 创建令牌
     * @param body
     * @return
     */
    public String createToken(BaseBody body) throws Exception {
        //设置redis key
        String token = tokenService.createToken(body);
        TokenAssert.isNotNull(body.getKey() , "缓存key不能为空");
        tokenCache.setToken(tokenCache.createRedisKey(body.getKey() , tokenService.getPrefix()) , token);
        return token;
    }

    public void checkToken(String token) throws Exception {
        BaseBody body = tokenService.getBody(token);
        TokenAssert.isNotNull(body , "token不合法");
        String redisKey = tokenCache.createRedisKey(body.getKey() , tokenService.getPrefix());
        String t = tokenCache.getToken(redisKey);
        TokenAssert.isNotNull(t , "token已过期");
        if(!t.equals(token)){
            throw new TokenException("token不合法");
        }
        //刷新时间
        tokenCache.refreshTime(redisKey);
    }

    /**
     * 根据token获取body内容
     * @param token
     * @return
     */
    public <T> T getBody(String token , Class<T> tClass) throws Exception {
        checkToken(token);
        return JSONObject
                .parseObject(tokenService
                        .getBody(token).getBody().toString() , tClass);
    }


    public Authorize setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
        return this;
    }

    public Authorize setTokenCache(ITokenCache tokenCache) {
        this.tokenCache = tokenCache;
        return this;
    }
}
