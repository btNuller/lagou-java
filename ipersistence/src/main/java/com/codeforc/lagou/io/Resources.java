package com.codeforc.lagou.io;

import java.io.InputStream;

/**
 * @Description: 配置文件加载InputStream
 * @Author: Ifan
 * date: 2021-03-04
 **/
public class Resources {

    /**
     * 获取ResourceAsStream
     * @param path 文件路径
     * @return IS
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }

}
