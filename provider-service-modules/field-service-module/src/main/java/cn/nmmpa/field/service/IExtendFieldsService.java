package cn.nmmpa.field.service;

import cn.nmmpa.field.model.BaseExtendFields;
import cn.nmmpa.field.model.ExtendFields;
import cn.nmmpa.common.base.service.IBaseService;

import java.util.Map;

/**
 * @author TanShuai
 * @version 1.0 2019年8月29日
 */
public interface IExtendFieldsService extends IBaseService<ExtendFields> {

    /**
     * 根据站点和表code查询扩展字段
     * @param userCode
     * @param tableCode
     * @param siteCode
     * @return
     */
    Map<String , String> getFields(String userCode , String tableCode , String siteCode);

    /**
     * 新增扩展字段
     * @param extendFields
     * @param userCode
     * @param tableCode
     * @param siteCode
     */
    void addExtendFields(BaseExtendFields extendFields , String userCode ,
                         String tableCode, String siteCode);


}