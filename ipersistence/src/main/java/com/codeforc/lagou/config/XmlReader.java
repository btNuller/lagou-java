package com.codeforc.lagou.config;

import com.codeforc.lagou.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description: 读取Xml信息
 * @Author: Ifan
 * date: 2021-03-06
 **/
public interface XmlReader {

    Configuration read(InputStream inputStream) throws DocumentException, PropertyVetoException;
}
