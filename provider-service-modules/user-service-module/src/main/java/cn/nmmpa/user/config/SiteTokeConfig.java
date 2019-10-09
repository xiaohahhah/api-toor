package cn.nmmpa.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * Created by TS on 2019/8/27.
 */
@Data
@Configuration
public class SiteTokeConfig {

    @Value("${token.public.key}")
    private String publicKey;

    @Value("${token.private.key}")
    private String privateKey;

    @Value("${token.prefix}")
    private String prefix;

    @Value("${token.refreshTime}")
    private Long refreshTime;

}
