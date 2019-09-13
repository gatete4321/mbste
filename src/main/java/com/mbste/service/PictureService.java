package com.mbste.service;

import com.mbste.model.Pictures;
import com.mbste.model.filters.PictureFilter;
import com.mbste.model.filters.PictureForm;

import java.util.List;
import java.util.Optional;

public interface PictureService
{
    List<Pictures> getClientPictures(PictureFilter filter);

    Optional<Pictures> getPictureById(PictureFilter filter);

    Integer deletePicture(PictureFilter filter);

    Optional<Pictures> getPicturesByNewsId(PictureFilter filter);

    Integer create(PictureForm form);
}
