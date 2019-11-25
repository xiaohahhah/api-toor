package cn.nmmpa.shiro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lhm
 * @date 2019/11/13 15:11
 **/
@Data
@ApiModel("登录结果vo")
public class LoginResultVo {

    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("角色：1,admin 2,customer")
    private String roleId;
    @ApiModelProperty("登录账号")
    private String account;

}
