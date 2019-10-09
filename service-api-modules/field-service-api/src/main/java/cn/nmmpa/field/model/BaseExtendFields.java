package cn.nmmpa.field.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * Created by TS on 2019/9/1.
 */
public class BaseExtendFields {

    @ApiModelProperty("扩展字段")
    private Map<String , String> extendFields;

    public Map<String, String> getExtendFields() {
        return extendFields;
    }

    public void setExtendFields(Map<String, String> extendFields) {
        this.extendFields = extendFields;
    }
}
