package com.mbste.service.impl;

import com.mbste.dao.BlogDao;
import com.mbste.model.Blog;
import com.mbste.model.filters.BlogsFilter;
import com.mbste.model.filters.BlogsForm;
import com.mbste.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao dao;

    @Override
    public List<Blog> getClientBlogs(BlogsFilter filter) {
        return dao.findByClientId(filter.getClientId());
    }

    @Override
    public Optional<Blog> getBlogById(BlogsFilter filter)
    {
        return Optional.ofNullable(dao.findById(filter.getBlogId()));
    }

    @Override
    public Integer deleteBlog(BlogsFilter filter) {
        return dao.delete(filter.getBlogId());
    }

    @Override
    public Integer deleteByNews(BlogsFilter filter) {

        return dao.deleteBynewsId(filter.getNewsId());
    }

    @Override
    public Blog getByNews(BlogsFilter filter) {
        return dao.findByNewsId(filter.getNewsId());
    }

    @Override
    public Integer createBlog(BlogsForm form) {
        return dao.createBlog(form);
    }


}
