package com.codeforc.lagou.pojo;

/**
 * @Description: 存放解析好的mapper.xml数据
 * @Author: Ifan
 * date: 2021-03-04
 **/
public class MappedStatement {

    public MappedStatement(String id, String resultType, String parameterType, String sql) {
        this.id = id;
        this.resultType = resultType;
        this.parameterType = parameterType;
        this.sql = sql;
    }

    private String id;

    private String resultType;

    private String parameterType;

    private String sql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
