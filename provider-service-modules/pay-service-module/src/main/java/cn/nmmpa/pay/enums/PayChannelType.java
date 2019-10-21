package cn.nmmpa.pay.enums;

import lombok.Getter;

/**
 * @author lhm
 * @date 2019/10/17 11:45
 **/
@Getter
public enum PayChannelType {

    /**
     * 支付目标类
     */
    tl("TlPayService", "通联支付"),
    yh("YhPayService", "农商支付");
    /**
     * 支付调用目标类
     */
    private String targetClass;

    /**
     * 目标类说明
     */
    private String details;

    PayChannelType(String targetClass, String details) {
        this.targetClass = targetClass;
        this.details = details;
    }
}
