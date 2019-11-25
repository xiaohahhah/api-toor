package cn.nmmpa.shiro.service.impl;

import cn.nmmpa.shiro.model.RolePermission;
import cn.nmmpa.shiro.service.IRolePermissionService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.shiro.mapper.RolePermissionMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper , RolePermission> implements IRolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;



}