package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 16:36
 * @Version 1.0
 */
@Data
public class UserLoginRespVo {

    @ApiModelProperty("用户code")
    private String userCode;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("性别 （1男 2女）")
    private Integer sex;
    @ApiModelProperty("注册时间")
    private java.util.Date registerTime;
    @ApiModelProperty("站点")
    private String siteCode;
    @ApiModelProperty("token")
    private String token;
}
