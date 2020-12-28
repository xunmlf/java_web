package com.ning;

import com.ning.entity.P;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TextMybatis {

    @Test
    public void textInsert() throws IOException {
        // 访问mybatis读取P
        // 1:定义mybatis主配置文件的名称,从类路径的根开始(target/classes)
        String config="mybatis.xml";
        // 2:读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        // 3:创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4:创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        // 5:【重要】创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 6:【重要】指定要执行的sql语句标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId="com.ning.dao.PDao.insertP";
        // 7:执行sal语句，通过sqlId找到语句
        P p = new P();
        p.setId(12);
        p.setName("ek");
        p.setPassword("446");
        p.setSex("women");
        p.setEmail("ek@qq.com");
        int nums = sqlSession.insert(sqlId,p);

        // mybatis默认是不会自动提交事务的，所以在  insert，update，delete后要手动提交事务
        sqlSession.commit();
        // 8:输出结果
        System.out.println("执行insert结果="+nums);
        // 9:关闭SqlSession对象
        sqlSession.close();
    }
}
