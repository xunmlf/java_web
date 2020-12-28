package com.ning.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {


    private static SqlSessionFactory factory = null;

    static {

        // 需要和你的项目中的文件名一样
        String config="mybatis.xml";
        try {
            InputStream  in = Resources.getResourceAsStream(config);

            // 创建sqlSessionFactory对象、
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取sqlSession的方法

    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}
