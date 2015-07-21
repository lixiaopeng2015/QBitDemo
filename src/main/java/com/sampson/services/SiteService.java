package com.sampson.services;

import com.sampson.dao.SiteDao;
import com.sampson.pojo.Site;
import io.advantageous.qbit.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lixiaopeng on 2015/7/15.
 */
@RequestMapping("/QBit")
public class SiteService {

    @RequestMapping("/sites")
    public List<Site> getSites(){
        SiteDao siteDao = new SiteDao();
        List<Site> list = siteDao.getSites();
        return list;
    }

}
