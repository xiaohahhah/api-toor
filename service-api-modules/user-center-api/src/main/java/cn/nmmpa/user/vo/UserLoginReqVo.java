package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 17:48
 * @Version 1.0
 */
@Data
public class UserLoginReqVo {

    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("用户密码")
    private String passWord;
    @ApiModelProperty("当前时间戳")
    private String time;
    @ApiModelProperty("加密串")
    private String sign;
}
