package com.mbste.controller;

import com.mbste.commons.utils.ReturnUtil;
import com.mbste.dao.BlogDao;
import com.mbste.model.Blog;
import com.mbste.model.filters.BlogsFilter;
import com.mbste.model.filters.BlogsForm;
import com.mbste.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public/blog")
public class BlogController
{
    @Autowired
    private BlogDao dao;
    @Autowired
    private BlogService service;

    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public String getAllBlogsByClient(@RequestBody BlogsFilter filter){
        Map<String,Object> map=new HashMap<>();
        List<Blog> blogs=service.getClientBlogs(filter);
        map.put("data",blogs);
        return ReturnUtil.resultSuccess(map);
    }
    @PostMapping(value = "/getById", produces = "application/json;charset=UTF-8")
    public String getBlogById(@RequestBody BlogsFilter filter){
        Map<String,Object> map=new HashMap<>();
        Blog blog=service.getBlogById(filter).get();
        map.put("data",blog);
        return ReturnUtil.resultSuccess(map);
    }
    @PostMapping(value = "/getByNews", produces = "application/json;charset=UTF-8")
    public String getBlogByNews(@RequestBody BlogsFilter filter)
    {
        Map<String,Object> map=new HashMap<>();
        Blog blog=service.getByNews(filter);
        return ReturnUtil.resultSuccess(map);
    }
    @PostMapping(value = "/deleteById", produces = "application/json;charset=UTF-8")
    public String deleteById(@RequestBody BlogsFilter filter){
        int result;
        result=service.deleteBlog(filter);
        if (result>0)
          return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }
    @PostMapping(value = "/deleteByNews", produces = "application/json;charset=UTF-8")
    public String deleteByNews(@RequestBody BlogsFilter filter){
        int result;
        result=service.deleteByNews(filter);
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }
    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public String createBlog(@RequestBody BlogsForm form){
        int result;
        result=service.createBlog(form);
        if (result>0)
          return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

}
