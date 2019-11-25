package cn.nmmpa.shiro.service.impl;

import cn.nmmpa.shiro.model.Permission;
import cn.nmmpa.shiro.service.IPermissionService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.shiro.mapper.PermissionMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper , Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


}