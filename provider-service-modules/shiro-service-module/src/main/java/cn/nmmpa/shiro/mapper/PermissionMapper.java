package cn.nmmpa.shiro.mapper;

import cn.nmmpa.shiro.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Repository
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {


}