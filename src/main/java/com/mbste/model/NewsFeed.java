package com.mbste.model;

import java.util.Date;

public class NewsFeed
{
    private Integer newsId;

    private Integer cientId;

    private  Integer pictureId;

    private Integer blogId;

    private Integer status;

    private Date    createdTime;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getCientId() {
        return cientId;
    }

    public void setCientId(Integer cientId) {
        this.cientId = cientId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
