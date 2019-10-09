package cn.nmmpa.user.mapper;

import cn.nmmpa.user.model.Site;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import cn.nmmpa.common.base.mapper.BaseMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Repository
@Mapper
public interface SiteMapper extends BaseMapper<Site> {


}