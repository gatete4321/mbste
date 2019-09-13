package com.mbste.service.impl;

import com.mbste.dao.PicturesDao;
import com.mbste.model.Pictures;
import com.mbste.model.filters.PictureFilter;
import com.mbste.model.filters.PictureForm;
import com.mbste.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PicturesDao dao;

    @Override
    public List<Pictures> getClientPictures(PictureFilter filter) {

        return dao.findByClientId(filter.getClientId());
    }

    @Override
    public Optional<Pictures> getPictureById(PictureFilter filter) {
        filter.setClientId(null);
        filter.setNewsId(null);
        return Optional.ofNullable(dao.findById(filter));
    }

    @Override
    public Integer deletePicture(PictureFilter filter)
    {
        return dao.delete(filter);
    }

    @Override
    public Optional<Pictures> getPicturesByNewsId(PictureFilter filter)
    {
        filter.setClientId(null);
        filter.setPid(null);
        return Optional.of(dao.findById(filter));
    }

    @Override
    public Integer create(PictureForm form) {
        return dao.createPicture(form);
    }
}
