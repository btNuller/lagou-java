package com.codeforc.lagou.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: sqlMapperConfig配置信息
 * @Author: Ifan
 * date: 2021-03-04
 **/
public class Configuration {

    private DataSource dataSource;

    /**
     * statementid存储key，statementid = namespace.id
     */
    private Map<String, MappedStatement> mapping = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, MappedStatement> mapping) {
        this.mapping = mapping;
    }
}
