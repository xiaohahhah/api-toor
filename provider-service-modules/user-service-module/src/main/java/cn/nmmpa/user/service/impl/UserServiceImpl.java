package cn.nmmpa.user.service.impl;

import cn.nmmpa.common.constants.Constant;
import cn.nmmpa.common.exception.ProviderServiceException;
import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.common.util.StringUtil;
import cn.nmmpa.user.model.User;
import cn.nmmpa.user.service.IUserService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import cn.nmmpa.user.vo.UserLoginReqVo;
import cn.nmmpa.user.vo.UserLoginRespVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.user.mapper.UserMapper;

import java.util.Date;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper , User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserMapper getMapper(){ 
       return userMapper;
    }

    @Override
    public void add(User user) {
        //验证该站点下手机号是否注册
        int res = this.userMapper.checkTel(user.getTel(), user.getSiteCode());
        if(res > 0){
            throw new ProviderServiceException(ExceptionEnum.TEL_EXISTENCE);
        }
        Date date = new Date();
        user.setUserCode(StringUtil.uuid());
        user.setIsDelete(0);
        user.setUserStatus(0);
        user.setCreateTime(date);
        user.setRegisterTime(date);
        user.setUpdateTime(date);
        user.setSalt(StringUtil.getStringRandom(6));
        user.setPassWord(MD5Util.MD5(
                new StringBuffer(user.getPassWord())
                        .append(user.getSalt()).toString()));
        this.userMapper.insert(user);
    }

    @Override
    public UserLoginRespVo login(UserLoginReqVo userLoginReqVo) {
        User user = new User();
        user.setTel(user.getTel());
        user = this.userMapper.queryConditionsToObject(user);
        //判断用户信息
        if(user == null || !MD5Util.MD5(
                new StringBuilder(userLoginReqVo.getPassWord())
                        .append(user.getSalt()).toString()).equals(user.getPassWord())){
            throw new ProviderServiceException(ExceptionEnum.PARAM_ERROR.setMessage("用户名或密码错误"));
        }
        //判断用户是否被禁用
        if(user.getUserStatus().equals(Constant.USER_DISENABLE_STATE)){
            throw new ProviderServiceException(ExceptionEnum.USER_DISENABLE);
        }

        return null;
    }
}