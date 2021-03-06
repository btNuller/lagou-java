package com.codeforc.lagou.config;

/**
 * @Description: 记录关键配置文件数据的名称和值
 * @Author: Ifan
 * date: 2021-03-06
 **/
public interface XmlConfigProperty {

    String CONFIG_DATASOURCE = "datasource";

    String CONFIG_MAPPER = "mapper";

    String DATASOURCE_URL = "jdbcUrl";

    String DATASOURCE_DRIVER = "driverClass";

    String DATASOURCE_USERNAME = "username";

    String DATASOURCE_PASSWORD = "password";

    String XML_ATTRIBUTE_NAME = "name";

    String XML_ATTRIBUTE_VALUE = "vaule";

    String ATTRIBUTE_RESOURCE = "resource";

    String NAMESPACE = "namespace";

    String ID = "id";

    String RESULT_TYPE = "resultType";

    String PARAMETER_TYPE = "parameterType";
}
