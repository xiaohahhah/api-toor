package cn.nmmpa.field.service;

import cn.nmmpa.common.base.service.IBaseService;
import cn.nmmpa.field.model.TableExtendTemplate;
import cn.nmmpa.field.vo.TableExtendTemplateAddReqVo;
import cn.nmmpa.field.vo.TableExtendTemplateDeleteReqVo;


import java.util.List;

/**
 * @author TanShuai
 * @version 1.0 2019年8月28日
 */
public interface ITableExtendTemplateService extends IBaseService<TableExtendTemplate> {

    /**
     * 新增扩展字段
     * @param templateAddReqVo
     */
    void add(TableExtendTemplateAddReqVo templateAddReqVo);

    /**
     * 查询表对应的扩展字段
     * @param siteCode
     * @param tableCode
     * @return
     */
    List<String> selectByFields(String siteCode, String tableCode);

    /**
     * 删除
     * @param templateDeleteReqVo
     */
    void deleteById(TableExtendTemplateDeleteReqVo templateDeleteReqVo);


}