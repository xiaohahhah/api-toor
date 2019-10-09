package cn.nmmpa.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年9月19日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "")
public class User extends BaseModel {

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
    @ApiModelProperty("用户密码")
    private String passWord;
    @ApiModelProperty("注册时间")
    private java.util.Date registerTime;
    @ApiModelProperty("加密盐")
    private String salt;
    @ApiModelProperty("站点")
    private String siteCode;
    @ApiModelProperty("用户状态（0未禁用 1禁用）")
    private Integer userStatus;
    @ApiModelProperty("是否删除（0未删除 1删除）")
    private Integer isDelete;

}