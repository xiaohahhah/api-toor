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
@ApiModel(value = "用户角色表")
@TableName("user_role")
public class UserRole extends BaseModel {

    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("角色id")
    private Integer roleId;

}