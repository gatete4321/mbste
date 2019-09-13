package com.mbste.dao;

import com.mbste.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDao
{
    public  int createBlog(Blog blog);

    public Blog findById(Integer blogId);

    public Blog findByNewsId(Integer newsId);

    public List<Blog> findByClientId(Integer clientId);

    public int deleteByClientId(Integer clientId);

    public int deleteBynewsId(Integer newsId);

    public int delete(Integer id);
}
