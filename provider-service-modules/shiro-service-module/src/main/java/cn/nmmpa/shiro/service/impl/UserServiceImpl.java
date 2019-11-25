package cn.nmmpa.shiro.service.impl;

import cn.nmmpa.shiro.mapper.UserMapper;
import cn.nmmpa.shiro.model.User;
import cn.nmmpa.shiro.service.IUserService;
import cn.nmmpa.shiro.vo.LoginResultVo;
import cn.nmmpa.shiro.vo.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements IUserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public LoginResultVo login(LoginVo vo){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("accout",vo.getAccount());







        return null;

    }
}