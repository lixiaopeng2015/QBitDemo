package com.sampson.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lixiaopeng on 2015/7/9.
 */
public class MyBatisUtil {
    private static Logger logger = LoggerFactory.getLogger(MyBatisUtil.class);
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    private final static String RESOURCE = "mybatis-config.xml";

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(RESOURCE);
        } catch (IOException e) {
            logger.error("load " + RESOURCE + " failure....");
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void rebuildSqlSessionFactory() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(RESOURCE);
        } catch (IOException e) {
            throw new RuntimeException("Get resource error:" + RESOURCE, e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSession openSession() {
        SqlSession session = threadLocal.get();
        if (session != null) {
            if (sqlSessionFactory == null) {
                getSqlSessionFactory();
            }
            session = (sqlSessionFactory != null) ? sqlSessionFactory.openSession() : null;
        }
        return session;
    }

    public static void closeSession() {
        SqlSession session = threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}
