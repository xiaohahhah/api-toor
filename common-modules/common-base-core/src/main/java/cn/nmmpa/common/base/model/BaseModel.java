package cn.nmmpa.common.base.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: tan shuai
 * @Date: 2019/6/27 16:20
 * @Version 1.0
 */
public class BaseModel implements Serializable {

    private Long id;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
