package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by TS on 2019/8/26.
 */
@Data
public class SiteSecretVo {

    @ApiModelProperty("接口权限appId")
    private String appId;
    @ApiModelProperty("接口权限密钥")
    private String secretKey;
}
