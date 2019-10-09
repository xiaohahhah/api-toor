package cn.nmmpa.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "")
public class Site extends BaseModel {

    @ApiModelProperty("站点名字")
    private String siteName;
    @ApiModelProperty("站点登陆账号（只能以字母开头，且只允许含有字母，数字，下划线）")
    private String account;
    @ApiModelProperty("手机号")
    private String tel;
    @ApiModelProperty("密码")
    private String passWord;
    @ApiModelProperty("站点code")
    private String siteCode;
    @ApiModelProperty("接口权限appId")
    private String appId;
    @ApiModelProperty("接口权限密钥")
    private String secretKey;
    @ApiModelProperty("加密盐")
    private String salt;
    @ApiModelProperty("是否删除（0未删除 2删除）")
    private Integer isDelete;

}