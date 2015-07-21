package com.sampson.dao;

import com.sampson.mapper.SiteMapper;
import com.sampson.pojo.Site;
import com.sampson.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by lixiaopeng on 2015/7/15.
 */
public class SiteDao {
    private static final Logger logger = LoggerFactory.getLogger(SiteDao.class);

    public List<Site> getSites(){
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        if (sqlSession == null) {
            logger.error("obtain SqlSession failure...");
        }
        try {
            SiteMapper siteMapper = sqlSession.getMapper(SiteMapper.class);
            return siteMapper.getSites();
        } catch (Exception e) {
            logger.error("SiteDao class getSites method exceptioin,get sites list failure...");
        }finally {
            sqlSession.close();
        }
        return null;
    }
}
