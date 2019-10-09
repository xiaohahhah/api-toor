package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 18:15
 * @Version 1.0
 */
@Data
public class UserTokenBody {

    @ApiModelProperty("站点code")
    private String siteCode;
    @ApiModelProperty("用户code")
    private String userCode;
}
