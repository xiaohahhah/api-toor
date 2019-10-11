package cn.nmmpa.wx.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年10月11日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "用户微信信息表")
public class BmMemberWx extends BaseModel {

    @ApiModelProperty("平台编码")
    private String platformCode;
    @ApiModelProperty("会员uuid")
    private String memberUuid;
    @ApiModelProperty("OPENID")
    private String openId;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户统一标识")
    private String unionId;
    @ApiModelProperty("用户头像")
    private String headImgUrl;
    @ApiModelProperty("普通用户性别，1为男性，2为女性")
    private Integer sex;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("国家，如中国为CN")
    private String country;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Byte isEnabled;

}