package com.mbste.service.impl;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.dao.NewsFeedDao;
import com.mbste.model.NewsFeed;
import com.mbste.model.filters.BlogsFilter;
import com.mbste.model.filters.NewsFeedFilter;
import com.mbste.model.filters.NewsFeedForm;
import com.mbste.model.filters.PictureFilter;
import com.mbste.service.BlogService;
import com.mbste.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements com.mbste.service.NewsService {
    @Autowired
    NewsFeedDao dao;

    @Autowired
    BlogService blogService;
    @Autowired
    PictureService pictureService;


    @Override
    public List<NewsFeed> getClientNews(NewsFeedFilter filter) {
       filter.setPaginationOffset();
       filter.setPaginationDates();
       filter.setNewsId(null);
        return dao.findById(filter);
    }

    @Override
    public NewsFeed getNewsById(NewsFeedFilter filter) {
        filter.setClientId(null);
        return (NewsFeed) dao.findById(filter);
    }

    @Override
    public Integer deleteNews(NewsFeedFilter filter) {
        filter.setClientId(null);
        int result;
        BlogsFilter blogsFilter=new BlogsFilter();
        blogsFilter.setNewsId(filter.getNewsId());
        result=blogService.deleteBlog(blogsFilter);
        if (!(result>0))
            throw new NotFoundException("enable to delete blogs");

        PictureFilter filter1=new PictureFilter();
        filter1.setNewsId(filter.getNewsId());
        result=pictureService.deletePicture(filter1);
        if (!(result>0))
            throw new NotFoundException("enable to delete pictures");
        return dao.delete(filter);
    }



    @Override
    public Integer createNews(NewsFeedForm form) {

        return dao.create(form);
    }

    @Override
    public Integer deleteByClientId(NewsFeedFilter filter) {
        filter.setNewsId(null);
        int result;
        BlogsFilter blogsFilter=new BlogsFilter();
        blogsFilter.setClientId(filter.getClientId());
        result=blogService.deleteBlog(blogsFilter);
        if (!(result>0))
            throw new NotFoundException("enable to delete blogs");

        PictureFilter filter1=new PictureFilter();
        filter1.setClientId(filter.getClientId());
        result=pictureService.deletePicture(filter1);
        if (!(result>0))
            throw new NotFoundException("enable to delete pictures");

        return dao.delete(filter);
    }
}
