package cn.nmmpa.user.config;

import cn.nmmpa.token.core.Authorize;
import cn.nmmpa.token.core.RedisTokenCache;
import cn.nmmpa.token.core.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 16:51
 * @Version 1.0
 */
@Configuration
public class AuthorizConfig {

    /**
     * 注入token生成器
     * @param redisTemplate
     * @param siteTokeConfig
     * @return
     */
    @Bean
    public Authorize authorize(@Autowired RedisTemplate redisTemplate ,
                              @Autowired SiteTokeConfig siteTokeConfig){
        return new Authorize()
                .setTokenCache(new RedisTokenCache()
                        .setRedisTemplate(redisTemplate)
                        .setRefreshTime(siteTokeConfig.getRefreshTime()))
                .setTokenService(new TokenService()
                        .setPrivateKey(siteTokeConfig.getPrivateKey())
                        .setPublicKey(siteTokeConfig.getPublicKey())
                        .setPrefix(siteTokeConfig.getPrefix()));
    }
}
