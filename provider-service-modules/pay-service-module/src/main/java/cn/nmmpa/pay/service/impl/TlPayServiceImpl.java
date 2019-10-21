package cn.nmmpa.pay.service.impl;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.pay.config.TlPayProperties;
import cn.nmmpa.pay.service.PayService;
import cn.nmmpa.pay.util.HttpConnectionUtil;
import cn.nmmpa.pay.util.SybUtil;
import cn.nmmpa.pay.vo.H5ResultVo;
import cn.nmmpa.pay.vo.PayReqVo;
import cn.nmmpa.pay.vo.RefundReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lhm
 * @date 2019/10/17 11:26
 **/
@Service("TlPayService")
@Slf4j
public class TlPayServiceImpl implements PayService {
    @Resource
    private TlPayProperties tlPayProperties;

    /**
     * 通联支付h5下单
     * @param payReqVo
     * @return
     * @throws Exception
     */
    @Override
    public ResultEntity<H5ResultVo> h5Pay(PayReqVo payReqVo) {
        H5ResultVo h5ResultVo = new H5ResultVo();
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<String, String>();
        try {
            params.put("cusid", tlPayProperties.getCusid());
            params.put("appid", tlPayProperties.getAppid());
            params.put("version", "12");
            params.put("trxamt", String.valueOf(payReqVo.getTrxamt()));
            params.put("reqsn", payReqVo.getMerchantOrderNo());
            params.put("charset", "utf-8");
            params.put("returl", "http://baidu.com");
            params.put("notify_url", payReqVo.getNotifyUrl());
            params.put("body", payReqVo.getBody());
            params.put("remark", payReqVo.getRemark());
            params.put("randomstr", SybUtil.getValidatecode(8));
            params.put("sign", SybUtil.sign(params, tlPayProperties.getAppKey()));
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(),"UTF-8")).append("&");
            }
            String h5Url = TlPayProperties.TlH5Url + "?" + sb.substring(0, sb.length() - 1);
            System.out.println(h5Url);
            h5ResultVo.setPayUrl(h5Url);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("h5下单失败:{}", e.toString());
        }

        return new ResultEntity<>(h5ResultVo);
    }




    /**
     * 通联支付扫码下单
     * @param payReqVo
     * @return
     * @throws Exception
     */
    @Override
    public ResultEntity<Map<String,String>> scanPay(PayReqVo payReqVo) throws Exception{

            HttpConnectionUtil http = new HttpConnectionUtil(TlPayProperties.TlUniUrl+"/scanqrpay");
            http.init();
            TreeMap<String,String> params = new TreeMap<String,String>();
            params.put("cusid", tlPayProperties.getCusid());
            params.put("appid", tlPayProperties.getAppid());
            params.put("version", "11");
            params.put("trxamt", String.valueOf(payReqVo.getTrxamt()));
            params.put("reqsn", payReqVo.getMerchantOrderNo());
            params.put("randomstr", SybUtil.getValidatecode(8));
            params.put("body", payReqVo.getBody());
            params.put("remark", payReqVo.getRemark());
            params.put("authcode", payReqVo.getAuthCode());
            params.put("sign", SybUtil.sign(params,tlPayProperties.getAppKey()));
            byte[] bys = http.postParams(params, true);
            String result = new String(bys,"UTF-8");
        System.out.println(result);
            Map<String,String> map = handleResult(result);
        System.out.println(map);
            return new ResultEntity<>(map) ;
    }

    /**
     * 通联支付回调
     * @param params
     * @param type 支付类型
     * @param notifyType 回调类型 pay-支付 refund-退款
     * @return
     * @throws Exception
     */
    @Override
    public Object callBack(String params, String type, String notifyType) {
//        acct=ogxuI5L1VTPPIElEb7KfxB28P1VI&appid=00000003&chnlid=205299480&chnltrxid=4200000412201910184984146780&cmid=310851053&cusid=990440148166000&cusorderid=1234567&fee=0&outtrxid=1234567&paytime=20191018102616&sign=807CF5144928FF80BCEEA90F2BD2850C&signtype=MD5&termauthno=CFT&termrefnum=4200000412201910184984146780&termtraceno=0&trxamt=1&trxcode=VSP501&trxdate=20191018&trxid=111994120000975981&trxreserved=%E6%9D%8E%E7%BA%A2%E6%A2%85%E6%B5%8BDd%E8%AF%95%E6%94%AF%E4%BB%98&trxstatus=0000
        return null;
    }

    /**
     * 通联支付订单查询
     * @param type 支付类型
     * @param platformOrderId 商户平台账单id
     * @param orderId 账单id
     * @return
     * @throws Exception
     */
    @Override
    public ResultEntity queryOrder(String type, String platformOrderId, String orderId) {
        return null;
    }

    /**
     * 通联支付退款
     * @param refundReqVo
     * @return
     * @throws Exception
     */
    @Override
    public ResultEntity<Map<String,String>> refund(RefundReqVo refundReqVo) throws Exception{
            HttpConnectionUtil http = new HttpConnectionUtil(TlPayProperties.TlUniUrl+"/refund");
            http.init();
            TreeMap<String,String> params = new TreeMap<String,String>();
            params.put("cusid", tlPayProperties.getCusid());
            params.put("appid", tlPayProperties.getAppid());
            params.put("version", "11");
            params.put("trxamt", String.valueOf(refundReqVo.getTrxamt()));
            params.put("reqsn", refundReqVo.getReqsn());
            params.put("oldreqsn", refundReqVo.getOldReqsn());
            params.put("oldtrxid", refundReqVo.getOldTrxid());
            params.put("randomstr", SybUtil.getValidatecode(8));
            params.put("sign", SybUtil.sign(params,tlPayProperties.getAppKey()));
            byte[] bys = http.postParams(params, true);
            String result = new String(bys,"UTF-8");
            System.out.println("result:"+result);
           log.info("退款result: {}",result);
            Map<String,String> map = handleResult(result);
            return new ResultEntity<>(map);
    }

    /**
     * 验签
     * @param result
     * @return
     * @throws Exception
     */
    public  Map<String,String> handleResult(String result) throws Exception{

        Map map = SybUtil.json2Obj(result, Map.class);
        if(map == null){
            throw new Exception("返回数据错误");
        }
        if("SUCCESS".equals(map.get("retcode"))){
            TreeMap tmap = new TreeMap();
            tmap.putAll(map);
            String sign = tmap.remove("sign").toString();
            String sign1 = SybUtil.sign(tmap,tlPayProperties.getAppKey());
            if(sign1.toLowerCase().equals(sign.toLowerCase())){
                return map;
            }else{
                throw new Exception("验证签名失败");
            }

        }else{
            throw new Exception(map.get("retmsg").toString());
        }
    }

}
