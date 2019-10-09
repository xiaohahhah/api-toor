package cn.nmmpa.web.vo;

import cn.nmmpa.common.constants.Constant;
import cn.nmmpa.common.validate.SexCheckValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 9:53
 * @Version 1.0
 */
@Data
public class UserRegisterVo {

    @ApiModelProperty("手机号")
    @NotEmpty
    @Pattern(regexp = Constant.TEL_REGEXP ,message = "手机号不合法")
    private String tel;

    @ApiModelProperty("密码")
    @NotEmpty
    private String passWord;

    @ApiModelProperty("用户名字")
    @Length(max = 25)
    private String userName;

    @ApiModelProperty("对应站点appId")
    @NotEmpty
    private String appId;

    @ApiModelProperty("对应站点密钥")
    @NotEmpty
    private String secretKey;

    @ApiModelProperty("性别（1男 2女）")
    @SexCheckValue({1 , 2})
    private Integer sex;

    @ApiModelProperty("头像")
    @Length(max = 500)
    private String headImg;

    @ApiModelProperty("签名串")
    private String sign;

    @ApiModelProperty("当前时间戳")
    private String time;
}
