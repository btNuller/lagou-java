#  拉勾Java高薪训练营-阶段一开源框架源码

## Mybatis

### JDBC问题分析：

1. 数据库配置信息存在硬编码问题
2. 频繁创建释放数据库连接

### 自定义持久层框架

工程：本质上是对JDBC代码进行了封装

```
使用端：（项目）：引入自定义持久层框架的jar包
    提供两部分配置信息：数据库配置信息、sql配置信息：sql语句、参数类型、返回值类型
    使用配置文件来提供这两部分配置信息：
        1）sqlMapConfig.xml：存放数据库配置信息，存放mapper.xml全路径
        2）mapper.xml：存放sql配置信息

自定义持久层框架本身：（工程）：
    1)加载配置文件：根据配置文件的路径,加载配置文件成字节输入流，存储在内存中
        创建Resources类 ： 方法 Inputstream getResourceAsStream(String path)
    2)创建两个JavaBean：容器对象存放的就是对配置文件解析出来的内容
        configuration：核心配置陪存放sqlMapConfig.xml内容
        MappedStatement：映射配置类：存放mapper.xml解析出来的内容
    3)解析配置文件：dom4j
        创建类：SqlSessionFactoryBuilder方法：build(InputSteam in)
            第一：使用dom4j解析配置文件，讲解洗出来的内容封装到容器对象中
            第二：创建SqlSessionFactory对象：存放mapper.xml解析出来的内容
    4)创建SqlSessionFactory接口和实现类DefaultSqlSessionFactory
        第一：openSession():生产sqlSession
    5)创建SqlSession接口和实现类DefaultSession
        定义对数据库的crud操作
    6)创建Executor接口及实现类SimpleExecutor实现类
        query(Configuration, MappedStatement,Object... params)执行的就是JDBC代码
```

