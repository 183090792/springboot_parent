package com.fb.base.service.impl;

import com.fb.base.service.BaseService;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LYZ
 * @create 2018/11/14 16:01
 **/
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private Mapper<T> mapper;

    /**
     * 增加数据，不忽略空值
     * @param t
     * @return
     */
    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    /**
     * 增加数据忽略空值
     * @param t
     * @return
     */
    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    /**
     * 根据对象执行删除
     * @param t
     * @return
     */
    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }

    /**
     * 根据主键删除数据
     * @param t
     * @return
     */
    @Override
    public int deleteById(Object t) {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 根据主键查询一个对象
     * @param id
     * @return
     */
    @Override
    public T selectOneById(Object id) {
        return  (T)mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据对象信息查询一个对象
     * @param t
     * @return
     */
    @Override
    public T selectOne(T t) {
        return (T) mapper.selectOne(t);
    }

    /**
     * 修改一个对象，不忽略空值
     * @param t
     * @return
     */
    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    /**
     * 修改一个对象，忽略空值
     * @param t
     * @return
     */
    @Override
    public int updateSelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 获取数据集合
     * @return
     */
    @Override
    public List<T> getList() {
        return mapper.select(null);
    }

    /**
     * 获取分页数据
     * @param page  当前页
     * @param size  每页大小
     * @param t 对象
     * @param orderBy 排序类型
     * @return
     */
    @Override
    public PageInfo<T> getPageList(int page, int size,T t,String orderBy) {
        //分页查询
        PageHelper.startPage(page, size,orderBy);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<>(select);
        return pageInfo;
    }
}
