package cn.nmmpa.web.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.common.util.EncryptUtil;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.web.service.ISiteService;
import cn.nmmpa.web.vo.LoginReqVo;
import cn.nmmpa.web.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 17:48
 * @Version 1.0
 */
@RestController
@RequestMapping("rest")
@Api(description = "站点")
public class SiteController {

    @Autowired
    private ISiteService siteService;

    @ApiOperation("站点后台登陆")
    @PostMapping("/login")
    public ResultEntity<SiteLoginRespVo> login(@RequestBody LoginReqVo loginReqVo) throws Exception {
        return siteService.login(loginReqVo);
    }

    @ApiOperation("模拟验签参数")
    @GetMapping("/getSign")
    public Map<String , String> getSign(@RequestParam String account ,
                          @RequestParam String passWord){
        Map<String , String> map = new HashMap<>(0);
        map.put("account" , account);
        map.put("passWord" , MD5Util.MD5(passWord));
        map.put("time" , System.currentTimeMillis()+"");
        String paramStr = EncryptUtil.getParamStr(map);
        String sign = MD5Util.MD5(paramStr);
        map.put("sign" , sign);
        return map;
    }
}
