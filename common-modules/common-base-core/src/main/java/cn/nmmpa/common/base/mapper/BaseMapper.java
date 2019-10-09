package cn.nmmpa.common.base.mapper;

import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/6/27 16:32
 * @Version 1.0
 */
public interface BaseMapper<T> {

    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 批量新增
     * @param list
     * @return
     */
    int insertBatch(List<T> list);

    /**
     * 根据id修改
     * @param t
     * @return
     */
    int updateById(T t);

    /**
     * 按id删除
     * @param id
     * @return
     */
    int deleteById(Object id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 按条件查询
     * @param t
     * @return
     */
    T queryConditionsToObject(T t);

    /**
     * 按条件查询对象集合
     * @param t
     * @return
     */
    List<T> queryConditionsToList(T t);

}
