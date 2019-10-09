package cn.nmmpa.common.base.service.impl;


import cn.nmmpa.common.base.mapper.BaseMapper;
import cn.nmmpa.common.base.model.BaseModel;
import cn.nmmpa.common.base.service.IBaseService;

import java.util.List;


/**
 * @Author: tan shuai
 * @Date: 2019/4/30 9:06
 * @Version 1.0
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> implements IBaseService<T> {

    /**
     * mappers 注入方法
     * @return
     */
    public abstract M getMapper();

    @Override
    public int insert(T t) throws Exception{
        return this.getMapper().insert(t);
    }

    @Override
    public int insertBatch(List<T> list)throws Exception {
        return this.getMapper().insertBatch(list);
    }

    @Override
    public int updateById(T t)throws Exception {
        return this.getMapper().updateById(t);
    }

    @Override
    public int deleteById(Object id)throws Exception {
        return this.getMapper().deleteById(id);
    }

    @Override
    public T selectById(Object id) throws Exception{
        return this.getMapper().selectById(id);
    }

    @Override
    public T queryConditionsToObject(T t) throws Exception{
        return this.getMapper().queryConditionsToObject(t);
    }

    @Override
    public List<T> queryConditionsToList(T t) throws Exception{
        return this.getMapper().queryConditionsToList(t);
    }
}
