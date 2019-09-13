package com.mbste.dao;

import com.mbste.model.NewsFeed;
import com.mbste.model.filters.NewsFeedFilter;
import com.mbste.model.filters.NewsFeedForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsFeedDao
{
    List<NewsFeed> findById(NewsFeedFilter filter);

    int delete(NewsFeedFilter filter);

    int create(NewsFeedForm form);

}
