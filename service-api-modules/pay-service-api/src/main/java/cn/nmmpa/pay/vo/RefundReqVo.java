package cn.nmmpa.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author lhm
 * @date 2019/10/17 14:49
 **/
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("退款请求vo")
public class RefundReqVo {
    @ApiModelProperty("退款金额")
    private String trxamt;
    @ApiModelProperty("原交易订单号")
    private String oldReqsn;
    @ApiModelProperty("商户退款单号")
    private String reqsn;
    @ApiModelProperty("订单标题")
    private String body;
    @ApiModelProperty("对一笔交易的具体描述信息（自定义扩展数据）")
    private Map<String , Object> extend;
    @ApiModelProperty("原交易流水")
    private String oldTrxid;
    @ApiModelProperty("备注")
    private String remark;

}
