package cn.nmmpa.shiro.controller;

import cn.nmmpa.shiro.service.IUserService;
import cn.nmmpa.shiro.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ResponseMessage;

import javax.annotation.Resource;

/**
 * @author lhm
 * @date 2019/10/25 10:09
 **/
@Api(tags = "shiro权限控制统一测试")
@RestController
@RequestMapping("shiro")
public class ShiroController {
    @Resource
    private IUserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResponseMessage login(@RequestBody @Validated LoginVo dto) {
        return userService.login(dto);
    }
}
