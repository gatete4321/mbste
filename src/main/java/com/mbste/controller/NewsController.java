package com.mbste.controller;

import com.mbste.commons.utils.ReturnUtil;
import com.mbste.dao.NewsFeedDao;
import com.mbste.model.NewsFeed;
import com.mbste.model.filters.NewsFeedFilter;
import com.mbste.model.filters.NewsFeedForm;
import com.mbste.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public/news")
public class NewsController
{
    @Autowired
    private NewsFeedDao dao;
    @Autowired
    private NewsService service;

    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public String geClientNews(@RequestBody NewsFeedFilter filter){
        Map<String,Object> objectMap=new HashMap<>();
        List<NewsFeed> feeds=service.getClientNews(filter);
        objectMap.put("data",feeds);
        return ReturnUtil.resultSuccess(objectMap);
    }
    @PostMapping(value = "/getById", produces = "application/json;charset=UTF-8")
    public String getNewsById(@RequestBody NewsFeedFilter filter){
        Map<String,Object> map=new HashMap<>();
        NewsFeed feed=service.getNewsById(filter);
        return ReturnUtil.resultSuccess(map);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public String delete(@RequestBody NewsFeedFilter filter)
    {
        int result;
        result=service.deleteNews(filter);
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }


    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public String cretaeNews(@RequestBody NewsFeedForm form){
        int result;
        result=service.createNews(form);
        if (result>0)
           return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

    @PostMapping(value = "/deleteAll", produces = "application/json;charset=UTF-8")
    public String deleteAll(NewsFeedFilter filter){
        int result;
        result=service.deleteByClientId(filter);
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

}
