package cn.nmmpa.user.service;

import cn.nmmpa.common.base.service.IBaseService;
import cn.nmmpa.user.model.User;
import cn.nmmpa.user.vo.UserLoginReqVo;
import cn.nmmpa.user.vo.UserLoginRespVo;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 新增用户
     * @param user
     */
    void add(User user);

    /**
     * 用户登陆
     * @param userLoginReqVo
     * @return
     */
    UserLoginRespVo login(UserLoginReqVo userLoginReqVo);

}