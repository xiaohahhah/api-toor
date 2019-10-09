package cn.nmmpa.user.mapper;

import cn.nmmpa.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import cn.nmmpa.common.base.mapper.BaseMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 验证该站点下手机号是否注册
     * @param tel
     * @param siteCode
     * @return
     */
    int checkTel(String tel , String siteCode);


}