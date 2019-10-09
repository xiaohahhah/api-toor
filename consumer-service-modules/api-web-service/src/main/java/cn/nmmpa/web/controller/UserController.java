package cn.nmmpa.web.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.common.util.EncryptUtil;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.web.service.IUserService;
import cn.nmmpa.web.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 10:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(description = "站点用户")
@Validated
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    ResultEntity userRegister(@Valid @RequestBody UserRegisterVo userRegisterVo) throws Exception {
        return userService.userRegister(userRegisterVo);
    }

    @ApiOperation("模拟用户注册请求参数")
    @GetMapping("/getParams")
    Map<String , String> getparams(@RequestParam String tel ,
                                   @RequestParam String passWord,
                                   @RequestParam String appId,
                                   @RequestParam String secretKey){
        Map<String , String> params = new HashMap<>(5);
        params.put("tel" , tel);
        params.put("passWord" , passWord);
        params.put("appId" , appId);
        params.put("secretKey" , secretKey);
        params.put("time" , System.currentTimeMillis()+"");
        String sign = MD5Util.MD5(EncryptUtil.getParamStr(params));
        params.put("sign" , sign);
        return params;
    }
}
