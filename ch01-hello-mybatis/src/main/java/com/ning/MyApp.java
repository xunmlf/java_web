package com.ning;

import com.ning.entity.P;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class MyApp {

    public static void main(String[] args) throws IOException {

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
