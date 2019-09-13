package com.mbste.dao;

import com.mbste.model.Appoitement;
import com.mbste.model.filters.AppoitementFilter;
import com.mbste.model.filters.AppoitementForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppoitementDao
{
    Appoitement findById(Integer id);

    List<Appoitement> findByClientId(Integer clientId);

    List<Appoitement> getAll();

    List<Appoitement> findByPlaque(String plaque);

    Integer countAll(AppoitementForm form);

    int createAppoitement(AppoitementForm form);

    int makeFeedback(String feed);

    int rate(Integer rate);

    int updateAppoitement(AppoitementForm form);

    List<Integer> getRates(Integer techId);

    int delete(AppoitementFilter filter);
}
