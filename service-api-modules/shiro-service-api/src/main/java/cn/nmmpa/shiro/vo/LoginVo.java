package cn.nmmpa.shiro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lhm
 * @date 2019/11/13 15:12
 **/
@ApiModel("登录vo")
@Data
public class LoginVo {

    @ApiModelProperty("帐号")
    @NotBlank(message = "帐号不能为空")
    private String account;
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;


}
