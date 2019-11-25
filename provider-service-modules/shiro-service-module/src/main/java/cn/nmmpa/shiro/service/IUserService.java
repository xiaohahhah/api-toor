package cn.nmmpa.shiro.service;

import cn.nmmpa.shiro.model.User;
import cn.nmmpa.common.base.service.IBaseService;
import cn.nmmpa.shiro.vo.LoginResultVo;
import cn.nmmpa.shiro.vo.LoginVo;
import com.baomidou.mybatisplus.extension.service.IService;
import springfox.documentation.service.ResponseMessage;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
public interface IUserService extends IService<User> {


    LoginResultVo login(LoginVo dto);
}