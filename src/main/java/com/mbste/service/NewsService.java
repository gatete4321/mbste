package com.mbste.service;

import com.mbste.model.NewsFeed;
import com.mbste.model.filters.NewsFeedFilter;
import com.mbste.model.filters.NewsFeedForm;

import java.util.List;

public interface NewsService
{
    List<NewsFeed> getClientNews(NewsFeedFilter filter);

    NewsFeed getNewsById(NewsFeedFilter filter);

    Integer deleteNews(NewsFeedFilter filter);

    Integer createNews(NewsFeedForm form);

    Integer deleteByClientId(NewsFeedFilter filter);
}
