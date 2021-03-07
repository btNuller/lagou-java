package com.codeforc.lagou.factory;

import com.codeforc.lagou.pojo.Configuration;

/**
 * @Description: sql session default implement
 * @Author: Ifan
 * date: 2021-03-06
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public SqlSession openSession() {
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession();
        return defaultSqlSession;

    }
}
