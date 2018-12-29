package com.fb.base.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author LYZ
 * @create 2018/11/14 15:57
 **/
public interface BaseService<T> {
    /***
     * 增加数据，不忽略空值
     * @param t
     * @return
     */
    public int insert(T t);

    /***
     * 增加数据忽略空值
     * @param t
     * @return
     */
    public int insertSelective(T t);

    /***
     * 根据对象执行删除
     * @param t
     * @return
     */
    public int delete(T t);

    /***
     * 根据主键删除数据
     * @param t
     * @return
     */
    public int deleteById(Object t);

    /***
     * 根据主键查询一个对象
     * @param id
     * @return
     */
    public T selectOneById(Object id);

    /***
     * 根据对象信息查询一个对象
     * @param t
     * @return
     */
    public T selectOne(T t);

    /***
     * 修改一个对象，不忽略空值
     * @param t
     * @return
     */
    public int update(T t);

    /***
     * 修改一个对象，忽略空值
     * @param t
     * @return
     */
    public int updateSelective(T t);

    /**
     * 获取数据集合
     * @return
     */
    public List<T> getList();

    /***
     * 获取分页数据
     * @param page  当前页
     * @param size  每页大小
     * @param t 对象
     * @param orderBy 排序类型
     * @return
     */
    public PageInfo<T> getPageList(int page, int size, T t, String orderBy);
}
