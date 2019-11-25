package cn.nmmpa.shiro.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "用户表")
@TableName("user")
public class User extends BaseModel {

    @ApiModelProperty("帐号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String username;
    @ApiModelProperty("注册时间")
    private java.util.Date regTime;

}