package cn.nmmpa.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 16:58
 * @Version 1.0
 */
@Data
public class LoginReqVo {

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String passWord;

    @ApiModelProperty("签名")
    private String sign;

    @ApiModelProperty("当前时间戳")
    private String time;
}
