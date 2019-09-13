package com.mbste.service;

import com.mbste.model.Blog;
import com.mbste.model.filters.BlogsFilter;
import com.mbste.model.filters.BlogsForm;

import java.util.List;
import java.util.Optional;

public interface BlogService
{
    public List<Blog> getClientBlogs(BlogsFilter filter);

    public Optional<Blog> getBlogById(BlogsFilter filter);

    public Integer deleteBlog(BlogsFilter filter);

    Integer deleteByNews(BlogsFilter filter);

    Blog getByNews(BlogsFilter filter);

    Integer createBlog(BlogsForm form);

}
