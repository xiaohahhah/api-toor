package cn.nmmpa.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author lhm
 * @date 2019/10/17 15:39
 **/
@Data
@ApiModel("h5支付结果vo")
public class H5ResultVo {

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("商户订单号")
    private String merchantOrderNo;

    @ApiModelProperty("扫码链接字符串")
    private String payUrl;

    @ApiModelProperty("H5支付响应信息map")
    private Map<String, String> result;
}
