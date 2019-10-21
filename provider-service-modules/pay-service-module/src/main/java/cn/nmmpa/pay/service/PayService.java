package cn.nmmpa.pay.service;


import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.pay.vo.H5ResultVo;
import cn.nmmpa.pay.vo.PayReqVo;
import cn.nmmpa.pay.vo.RefundReqVo;
import springfox.documentation.service.ResponseMessage;


/**
 * @author lhm
 * @date 2019/10/17 11:05
 **/

public interface PayService {

    /**
     * h5下单接口
     * @param payReqVo
     * @return
     * @throws Exception
     */
    ResultEntity<H5ResultVo> h5Pay(PayReqVo payReqVo);



    /**
     * 扫码下单接口
     * @param payReqVo
     * @return
     * @throws Exception
     */
    ResultEntity scanPay(PayReqVo payReqVo) throws Exception;

    /**
     * 统一支付回调接口
     * @param params
     * @param type 支付类型
     * @param notifyType 回调类型 pay-支付 refund-退款
     * @return
     * @throws Exception
     */
    Object callBack(String params, String type , String notifyType);

    /**
     * 商户平台账单查询
     * @param type 支付类型
     * @param platformOrderId 商户平台账单id
     * @param orderId 账单id
     * @return 返回当前支付类型账单信息
     * @throws Exception
     */
    ResultEntity queryOrder(String type, String platformOrderId, String orderId) ;

    /**
     * 退款
     * @param refundReqVo
     * @return
     * @throws Exception
     */
    ResultEntity refund(RefundReqVo refundReqVo) throws Exception;
}
