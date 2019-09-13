package com.mbste.dao;

import com.mbste.model.Pictures;
import com.mbste.model.filters.PictureFilter;
import com.mbste.model.filters.PictureForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicturesDao
{
    int createPicture(PictureForm form);
    Pictures findById(PictureFilter filter);
    int delete(PictureFilter filter);
    List<Pictures> findByClientId(Integer id);
}
