package com.codeforc.lagou.config;

import com.codeforc.lagou.io.Resources;
import com.codeforc.lagou.pojo.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @Description: 读取配置文件中的信息
 * @Author: Ifan
 * date: 2021-03-06
 **/
public class XmlConfigReader implements XmlConfigProperty, XmlReader {

    private Configuration configuration;

    public XmlConfigReader (){
        this.configuration = new Configuration();
    }

    /**
     * 解析sqlMapperConfig.xml和mapper.xml
     * @param inputStream 流
     * @return conf
     * @throws DocumentException dom4jException
     * @throws PropertyVetoException propertyException
     */
    public Configuration read(InputStream inputStream) throws DocumentException, PropertyVetoException {
        Document sqlMapperConfigDocument = new SAXReader().read(inputStream);


        Element rootElement = sqlMapperConfigDocument.getRootElement();
        List<Element> properties = rootElement.selectNodes("//property");

        Properties propertiesMap = new Properties();
        for (Element property : properties) {
            String name = property.attributeValue(XML_ATTRIBUTE_NAME);
            String value = property.attributeValue(XML_ATTRIBUTE_VALUE);
            propertiesMap.setProperty(name, value);
        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(propertiesMap.getProperty(DATASOURCE_DRIVER));
        comboPooledDataSource.setJdbcUrl(propertiesMap.getProperty(DATASOURCE_URL));
        comboPooledDataSource.setUser(DATASOURCE_USERNAME);
        comboPooledDataSource.setPassword(propertiesMap.getProperty(DATASOURCE_PASSWORD));

        configuration.setDataSource(comboPooledDataSource);

        List<Element> mappers = rootElement.selectNodes("//mapper");
        for (Element mapperElement : mappers) {
            String mapperPath = mapperElement.attributeValue(ATTRIBUTE_RESOURCE);
            InputStream mapperInputStream = Resources.getResourceAsStream(mapperPath);
            XmlMapperReader xmlMapperReader = new XmlMapperReader(configuration);
            xmlMapperReader.read(mapperInputStream);
        }

        return configuration;
    }
}
