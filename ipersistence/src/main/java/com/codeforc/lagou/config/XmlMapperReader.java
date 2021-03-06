package com.codeforc.lagou.config;

import com.codeforc.lagou.pojo.Configuration;
import com.codeforc.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 读取mapper.xml中的内容进行封装
 * @Author: Ifan
 * date: 2021-03-06
 **/
public class XmlMapperReader implements XmlConfigProperty, XmlReader {

    private Configuration configuration;

    public XmlMapperReader(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration read(InputStream inputStream) throws DocumentException {
        Document mapperDocument = new SAXReader().read(inputStream);
        Element rootElement = mapperDocument.getRootElement();
        String namespace = rootElement.attributeValue(NAMESPACE);

        Map<String, MappedStatement> mapping = new LinkedHashMap<>(16);


        List<Element> selectElements = rootElement.selectNodes("//select");
        for (Element selectElement : selectElements) {
            String id = selectElement.attributeValue(ID);
            String resultType = selectElement.attributeValue(RESULT_TYPE);
            String parameterType = selectElement.attributeValue(PARAMETER_TYPE);
            String sql = selectElement.getStringValue();
            MappedStatement selectMappedStatement = new MappedStatement(id, resultType, parameterType, sql);

            mapping.put(buildStatementId(namespace, id), selectMappedStatement);
        }
        return configuration;
    }

    /**
     * 构建statementId, 构建规则为 namespace + . + id
     * @param namespace mapper.xml namespace
     * @param id sql id
     * @return statementId
     */
    public static String buildStatementId(String namespace, String id) {
        return new StringBuilder().append(namespace).append(".").append(id).toString();
    }
}
