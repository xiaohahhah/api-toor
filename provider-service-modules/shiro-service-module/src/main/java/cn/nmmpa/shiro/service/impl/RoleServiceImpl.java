package cn.nmmpa.shiro.service.impl;

import cn.nmmpa.shiro.model.Role;
import cn.nmmpa.shiro.service.IRoleService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.shiro.mapper.RoleMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper , Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;


}