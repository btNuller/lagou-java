package com.codeforc.lagou.factory;

import com.codeforc.lagou.config.XmlConfigReader;
import com.codeforc.lagou.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description: 构建SqlSessionFactory对象
 * @Author: Ifan
 * date: 2021-03-06
 **/
public class SqlSessionFactoryBuilder {

    /**
     * 通过Dom4j解析出sqlMapperConfig.xml配置文件中的重要内容：datasource和mapper
     * @param inputStream is
     * @return sqlSessionFactory
     */
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException, PropertyVetoException {
        XmlConfigReader xmlConfigReader = new XmlConfigReader();
        Configuration configuration = xmlConfigReader.read(inputStream);

        //第二创建sqlSessionFactory对象：工厂类：生产SqlSession会话对象
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return null;
    }
}
