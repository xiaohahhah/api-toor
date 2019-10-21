package cn.nmmpa.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lhm
 * @date 2019/10/17 15:18
 **/
@Component
@ConfigurationProperties(prefix="com.unioninfo.tl")
@Data
public class TlPayProperties {
    public static final String TlH5Url = "https://syb.allinpay.com/apiweb/h5unionpay/unionorder";


    public static final String TlUniUrl = "https://vsp.allinpay.com/apiweb/unitorder";


    private String appid;

    private String appKey;

    private String cusid;

    private String notifyUrl;
}
