package com.mbste.controller;

import com.mbste.commons.utils.ReturnUtil;
import com.mbste.dao.PicturesDao;
import com.mbste.model.Pictures;
import com.mbste.model.filters.PictureFilter;
import com.mbste.model.filters.PictureForm;
import com.mbste.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/public/pic")
public class PictureController
{
    @Autowired
    PictureService service;
    @Autowired
    PicturesDao dao;


    @PostMapping(value = "/get", produces = "application/json;charset=UTF-8")
    public String getPictureById(@RequestBody PictureFilter filter){
        Map<String, Pictures> map=new HashMap<>();

        return ReturnUtil.resultSuccess();
    }
    @PostMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public String getAllPictures(@RequestBody PictureFilter filter){
        Map<String,Object> map=new HashMap<>();
        List<Pictures> pictures=service.getClientPictures(filter);
        map.put("data",pictures);
        return ReturnUtil.resultSuccess(map);
    }

    @PostMapping(value = "/pic", produces = "application/json;charset=UTF-8")
    public String getPictureByNewsId(@RequestBody PictureFilter filter){
       Map<String,Object> map=new HashMap<>();
       Pictures pictures=service.getPicturesByNewsId(filter).get();
       map.put("data",pictures);
        return ReturnUtil.resultSuccess(map);
    }
    @PostMapping(value = "/deleteByid", produces = "application/json;charset=UTF-8")
    public String delete(@RequestBody PictureFilter filter)
    {
        filter.setNewsId(null);
        filter.setClientId(null);
        int result;
        result=service.deletePicture(filter);
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();

    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public String createPicture(@RequestBody PictureForm form){
        int result;
        result=service.create(form);
        if (result>0)
           return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }

    @PostMapping(value = "/deleteByNews", produces = "application/json;charset=UTF-8")
    public String deleteByNews(@RequestBody PictureFilter filter){
        int result;
        filter.setClientId(null);
        filter.setPid(null);
        result=service.deletePicture(filter);
        if (result>0)
            return ReturnUtil.resultSuccess();

        return ReturnUtil.resultFail();
    }
    @PostMapping(value = "/getById", produces = "application/json;charset=UTF-8")
    public String getPicById(@RequestBody PictureFilter filter){
        Map<String,Object> map=new HashMap<>();
       Pictures pictures =service.getPictureById(filter).get();
       map.put("data",pictures);
        return ReturnUtil.resultSuccess(map);
    }
}
