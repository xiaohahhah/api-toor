package cn.nmmpa.web.service;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.web.vo.UserRegisterVo;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 9:52
 * @Version 1.0
 */
public interface IUserService {

    /**
     * 用户注册
     * @param userRegisterVo
     */
    ResultEntity userRegister(UserRegisterVo userRegisterVo) throws Exception;
}
