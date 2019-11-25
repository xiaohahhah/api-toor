package cn.nmmpa.shiro.service.impl;

import cn.nmmpa.shiro.model.UserRole;
import cn.nmmpa.shiro.service.IUserRoleService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.shiro.mapper.UserRoleMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper , UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


}