package cn.nmmpa.field.service.impl;

import cn.nmmpa.common.exception.AssertUtil;
import cn.nmmpa.field.model.BaseExtendFields;
import cn.nmmpa.field.model.ExtendFields;
import cn.nmmpa.field.service.IExtendFieldsService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import cn.nmmpa.field.service.ITableExtendTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.field.mapper.ExtendFieldsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author TanShuai
 * @version 1.0 2019年8月29日
 */
@Service
public class ExtendFieldsServiceImpl extends BaseServiceImpl<ExtendFieldsMapper , ExtendFields> implements IExtendFieldsService {

    @Autowired
    private ExtendFieldsMapper extendFieldsMapper;
    @Autowired
    private ITableExtendTemplateService tableExtendTemplateService;

    @Override
    public ExtendFieldsMapper getMapper(){ 
       return extendFieldsMapper;
    }

    @Override
    public Map<String, String> getFields(String userCode, String tableCode , String siteCode) {
        //判断站点是否有扩展字段
        Map<String , String> extendMap = new HashMap<>(0);
        List<String> list = tableExtendTemplateService.selectByFields(siteCode, tableCode);
        if(list == null || list.size() == 0){
            return extendMap;
        }
        //有扩展字段 初始化赋值
        list.stream()
                .forEach(field -> extendMap.put(field , null));
        ExtendFields extendFields = new ExtendFields();
        extendFields.setUserCode(userCode);
        extendFields.setTableCode(tableCode);
        List<ExtendFields> extendFieldsList = extendFieldsMapper.queryConditionsToList(extendFields);
        //该用户无扩展字段 直接返回
        if(extendFieldsList == null || extendFieldsList.size() == 0){
            return extendMap;
        }
        //赋值
        extendFieldsList
                .stream()
                .forEach(extendField -> {
                    if (extendMap.containsKey(extendField.getField())){
                        extendMap.put(extendField.getField() , extendField.getValue());
                    }
                });
        return extendMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addExtendFields(BaseExtendFields extendFields, String userCode,
                                String tableCode, String siteCode) {
        if(extendFields != null && extendFields.getExtendFields() != null
                && extendFields.getExtendFields().size() != 0){
            AssertUtil.isNotNull(userCode , "用户code不能为空");
            Map<String , String> fields = extendFields.getExtendFields();
            List<String> list = tableExtendTemplateService.selectByFields(siteCode, tableCode);
            if(list != null && list.size() != 0){
                List<ExtendFields> extendFieldsList = new ArrayList<>();
                Date date = new Date();
                for(String key : fields.keySet()){
                    if(list.contains(key) && fields.get(key) != null){
                        ExtendFields extendField = new ExtendFields();
                        extendField.setField(key);
                        extendField.setUserCode(userCode);
                        extendField.setTableCode(tableCode);
                        extendField.setValue(fields.get(key));
                        extendField.setCreateTime(date);
                        extendField.setUpdateTime(date);
                        extendFieldsList.add(extendField);
                    }
                }
                //判断实际添加字段是否为空
                if(extendFieldsList.size() > 0){
                    extendFieldsMapper.insertBatch(extendFieldsList);
                }
            }
        }
    }
}