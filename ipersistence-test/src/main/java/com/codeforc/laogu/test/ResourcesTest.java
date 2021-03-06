package com.codeforc.laogu.test;

import com.codeforc.lagou.io.Resources;

import java.io.InputStream;

/**
 * @Description: resources
 * @Author: Ifan
 * date: 2021-03-04
 **/
public class ResourcesTest {

    public static void main(String[] args) {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        System.out.println(resourceAsStream);
    }
}
