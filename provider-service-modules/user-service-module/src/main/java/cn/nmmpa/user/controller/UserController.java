package cn.nmmpa.user.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.model.User;
import cn.nmmpa.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tan shuai
 * @Date: 2019/9/2 12:28
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public ResultEntity add(@RequestBody User user) throws Exception {
        userService.add(user);
        return ResultEntity.success();
    }
}
