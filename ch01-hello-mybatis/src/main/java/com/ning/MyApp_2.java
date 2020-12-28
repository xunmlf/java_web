package com.ning;

import com.ning.entity.P;
import com.ning.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp_2 {
    public static void main(String[] args) throws IOException {

        // 5:【重要】创建SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 6:【重要】指定要执行的sql语句标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId="com.ning.dao.PDao"+"."+"selectP";
        // 7:执行sal语句，通过sqlId找到语句
        List<P> list = sqlSession.selectList(sqlId);
        // 8:输出结果
        for(P p:list){
            System.out.println(p);
        }
        // 9:关闭SqlSession对象
        sqlSession.close();
    }
}
