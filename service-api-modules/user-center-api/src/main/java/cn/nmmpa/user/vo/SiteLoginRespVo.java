package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: tan shuai
 * @Date: 2019/8/26 16:11
 * @Version 1.0
 */
@Data
public class SiteLoginRespVo implements Serializable {

    @ApiModelProperty("站点名字")
    private String siteName;
    @ApiModelProperty("站点登陆账号（只能以字母开头，且只允许含有字母，数字，下划线）")
    private String account;
    @ApiModelProperty("手机号")
    private String tel;
    @ApiModelProperty("站点code")
    private String siteCode;
    @ApiModelProperty("token")
    private String token;
}
