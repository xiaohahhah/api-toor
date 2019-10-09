package cn.nmmpa.field.service.impl;

import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import cn.nmmpa.common.exception.AssertUtil;
import cn.nmmpa.common.exception.ProviderServiceException;
import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.field.mapper.TableExtendTemplateMapper;
import cn.nmmpa.field.model.TableExtendTemplate;
import cn.nmmpa.field.service.ITableExtendTemplateService;
import cn.nmmpa.field.vo.TableExtendTemplateAddReqVo;
import cn.nmmpa.field.vo.TableExtendTemplateDeleteReqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author TanShuai
 * @version 1.0 2019年8月28日
 */
@Service
@CacheConfig(cacheNames = "TABLE_EXTEND_FIELDS")
public class TableExtendTemplateServiceImpl extends BaseServiceImpl<TableExtendTemplateMapper, TableExtendTemplate> implements ITableExtendTemplateService {

    @Autowired
    private TableExtendTemplateMapper tableExtendTemplateMapper;

    @Override
    public TableExtendTemplateMapper getMapper(){ 
       return tableExtendTemplateMapper;
    }

    @Override
    @CacheEvict(key = "#templateAddReqVo.siteCode+'_'+#templateAddReqVo.tableCode")
    public void add(TableExtendTemplateAddReqVo templateAddReqVo) {
        Date date = new Date();
        TableExtendTemplate tableExtendTemplate = new TableExtendTemplate();
        BeanUtils.copyProperties(templateAddReqVo , tableExtendTemplate);
        tableExtendTemplate.setIsDelete(0);
        tableExtendTemplate.setCreateTime(date);
        tableExtendTemplate.setUpdateTime(date);
        this.tableExtendTemplateMapper.insert(tableExtendTemplate);
    }

    @Override
    @Cacheable(key = "#siteCode+'_'+ #tableCode" ,sync = true)
    public List<String> selectByFields(String siteCode, String tableCode) {
        AssertUtil.isNotNull(siteCode , "站点code不能为空");
        AssertUtil.isNotNull(tableCode , "表code不能为空");
        return tableExtendTemplateMapper.selectByFields(siteCode, tableCode);
    }

    @Override
    @CacheEvict(key = "#templateDeleteReqVo.siteCode+'_'+#templateDeleteReqVo.tableCode")
    public void deleteById(TableExtendTemplateDeleteReqVo templateDeleteReqVo) {
        TableExtendTemplate template = new TableExtendTemplate();
        template.setId(templateDeleteReqVo.getId());
        template.setIsDelete(1);
        int res = tableExtendTemplateMapper.updateById(template);
        if(res == 0){
            throw new ProviderServiceException(ExceptionEnum.DELETE_ERROR);
        }
    }
}