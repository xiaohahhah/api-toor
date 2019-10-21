package cn.nmmpa.pay.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.pay.service.PayService;
import cn.nmmpa.pay.vo.H5ResultVo;
import cn.nmmpa.pay.vo.PayReqVo;
import cn.nmmpa.pay.vo.RefundReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

import javax.annotation.Resource;

/**
 * @author lhm
 * @date 2019/10/17 11:04
 **/
@Api(tags = "支付统一入口")
@RestController
@RequestMapping("pay")
public class PayController {

    @Resource
    private PayService payService;


    /**
     * h5支付  H5Pay
     */
    @ApiOperation("h5支付(用户扫码)")
    @PostMapping("/h5Pay")
    public ResultEntity  h5Pay(@RequestBody PayReqVo vo){
        return payService.h5Pay(vo);
    }



    @ApiOperation("csh5支付(用户扫码)")
    @PostMapping("/csh5Pay")
    public ResultEntity  csh5Pay( PayReqVo vo){
        return payService.h5Pay(vo);
    }


    @ApiOperation("回调")
    @PostMapping("/notify/{type}")
    public ResultEntity notify(@RequestBody String params, @PathVariable(value = "type") String type) throws Exception {
        System.out.println(params);
        return new ResultEntity("SUCCESS"+params);
    }


    @ApiOperation("统一退款")
    @PostMapping("/refund")
    public ResultEntity refund(@RequestBody @Validated RefundReqVo vo) throws Exception {
        return payService.refund(vo);
    }


    @ApiOperation("统一扫码（商户主扫）")
    @PostMapping("/scanPay")
    public ResultEntity scanPay(@RequestBody @Validated PayReqVo vo) throws Exception {
        return payService.scanPay(vo);
    }


}
