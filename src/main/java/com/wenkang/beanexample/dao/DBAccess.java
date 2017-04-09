package com.wenkang.beanexample.dao;
import com.wenkang.beanexample.BeanMain;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * Created by wenka on 2017/4/7.
 */
public class DBAccess
{
    public SqlSession getSqlSession()
    {
        //Configuration.xml在源码包种又范例，目录为mybatis-3-mybatis-3.4.2\src\test\java\org\apache\ibatis\submitted\complex_property
        //通过配置文件获取数据库连接信息,根目录为src
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            System.out.println(reader);
        } catch (IOException e) {
            System.out.println("读取Configuration.xml错误");
        }
        //通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过sqlSessionFactory打开一个数据库会话
        SqlSession sqlSession = null;
        try
        {
            sqlSession = sqlSessionFactory.openSession();
        }catch (Exception e)
        {
            System.out.println("建立sqlsession错误");
        }

        return sqlSession;
    }
}
