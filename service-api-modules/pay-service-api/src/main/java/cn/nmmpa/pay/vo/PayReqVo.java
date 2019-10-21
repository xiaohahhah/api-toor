package cn.nmmpa.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author lhm
 * @date 2019/10/17 14:38
 **/
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("基础支付vo")
public class PayReqVo {


    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("商户订单号")
    private String merchantOrderNo;
    @ApiModelProperty("订单标题")
    private String body;
    @ApiModelProperty("对一笔交易的具体描述信息（自定义扩展数据）")
    private Map<String , Object> extend;
    @ApiModelProperty("支付渠道")
    private String payChannel;
    @ApiModelProperty("用户真实ip")
    private String ipAddress;
    @ApiModelProperty("订单金额")
    private String trxamt;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("通知url")
    private String notifyUrl;
    @ApiModelProperty("授权码")
    private String authCode;
    @ApiModelProperty("支付类型")
    private String payType;


}
