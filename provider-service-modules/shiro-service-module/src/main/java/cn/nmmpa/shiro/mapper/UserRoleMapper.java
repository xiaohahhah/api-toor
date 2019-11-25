package cn.nmmpa.shiro.mapper;

import cn.nmmpa.shiro.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {


}