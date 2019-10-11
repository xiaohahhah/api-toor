package cn.nmmpa.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zengzhangni
 * @date 2019/6/3
 */
@ConfigurationProperties(prefix = "wx.config")
@Component
@Data
public class WxProperties {
    /**
     * appId 公众号的唯一标识
     */

    private String appId;
    /**
     * 密钥
     */
    private String appSecret;
    /**
     * 会员初始化头像
     */
    private String memberImgUrl;
    /**
     * 微信授权跳转uri
     */
    private String redirectUri;
    /**
     * 分享标题
     */
    private String title;
    /**
     * 分享描述
     */
    private String desc;
    /**
     * 分享链接地址
     */
    private String link;
    /**
     * logo 地址
     */
    private String imgUrl;

}