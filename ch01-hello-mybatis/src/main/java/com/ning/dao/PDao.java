package com.ning.dao;

import com.ning.entity.P;

import java.util.List;

/**
 * @author XUN~MLF
 * 接口操作pp表
 */
public interface PDao {


    /**查询pp表中的所有数据*/
    public List<P> selectP();

    /**插入方法
     * 参数：pp  ，表示要插入到数据库中
     * 返回值：int ,表示执行insert后，影响数据库的行数
     * */
    public int insertP(P p);


}
