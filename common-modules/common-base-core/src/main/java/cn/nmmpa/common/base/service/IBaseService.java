package cn.nmmpa.common.base.service;

import cn.nmmpa.common.base.model.BaseModel;

import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/6/27 17:44
 * @Version 1.0
 */
public interface IBaseService<T extends BaseModel> {

    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t)throws Exception;

    /**
     * 批量新增
     * @param list
     * @return
     */
    int insertBatch(List<T> list)throws Exception;

    /**
     * 根据id修改
     * @param t
     * @return
     */
    int updateById(T t)throws Exception;

    /**
     * 按id删除
     * @param id
     * @return
     */
    int deleteById(Object id)throws Exception;

    /**
     * 按id查询
     * @param id
     * @return
     * @throws Exception
     */
    T selectById(Object id) throws Exception;

    /**
     * 按条件查询
     * @param t
     * @return
     */
    T queryConditionsToObject(T t)throws Exception;

    /**
     * 按条件查询对象集合
     * @param t
     * @return
     */
    List<T> queryConditionsToList(T t)throws Exception;
}
