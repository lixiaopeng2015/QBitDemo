package com.sampson.pojo;

import java.io.Serializable;

/**
 * Created by lixiaopeng on 2015/7/9.
 */
public class Site implements Serializable{

    private static final long serialVersionUID = 1275143735365398266L;

    private long id;
    private String crawlSite;
    private String createTime;

    public Site() {
        super();
    }

    public Site(long id, String crawlSite, String createTime) {
        this.id = id;
        this.crawlSite = crawlSite;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrawlSite() {
        return crawlSite;
    }

    public void setCrawlSite(String crawlSite) {
        this.crawlSite = crawlSite;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
