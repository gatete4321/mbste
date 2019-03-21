package com.mbste.service.impl;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.dao.ClientDao;
import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.filters.ClientForm;
import com.mbste.service.ClientService;
import com.mbste.commons.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    ClientDao dao;

    @Override
    public List<Client> getClientsList(ClientFilter clientFilter) {
        clientFilter.setPaginationDates();
        clientFilter.setPaginationOffset();
        return dao.getAll(clientFilter);
    }

    @Override
    public Optional<Client> findById(Integer clientId) {

        return Optional.of(dao.findById(clientId));
    }

    @Override
    public String createNewClient(ClientForm clientForm) {
        //track insert results
        int result=0;

        if (checkUsername(clientForm.getUsername())==null) {
            result = dao.createClient(clientForm);
        }
        else{
            throw new NotFoundException("the username has taken");
        }
        if(result>0 ){
            return ReturnUtil.resultSuccess();
        }else {
            return ReturnUtil.resultFail("Database insertion failure");
            //throw new NotFoundException("the name was taken ");
        }
    }

    @Override
    public String updateClient(ClientForm clientForm) {
        int result= dao.updateClient(clientForm);
        if(result>0){
            return ReturnUtil.resultSuccess();
        }else {
            return ReturnUtil.resultFail("Database updation  failure");
        }
    }

    @Override
    public Client login(String username, String pwd) {
        return null;
    }

    @Override
    public int countAll(ClientFilter clientFilter) {
        return  dao.count(clientFilter);
    }

    @Override
    public Optional<Client> findByUsername(String username) {
        Optional<Client> client=Optional.of(dao.findByUsername(username));
        return client;
    }

    @Override
    public String changePassword(ClientForm clientForm) {
        int result= dao.changePassword(clientForm);
        if(result>0){
            return ReturnUtil.resultSuccess();
        }else {
            return ReturnUtil.resultFail("Database updation  failure");
        }
    }

    @Override
    public String changeProfileImage(ClientForm clientForm) {
        int result= dao.changeProfileImage(clientForm);
        if(result>0){
            return ReturnUtil.resultSuccess();
        }else {
            return ReturnUtil.resultFail("Database updation  failure");
        }
    }

    @Override
    public String getAll() {
        Map<String,Object> result= new HashMap<>();
        List<Client> clients=dao.getAll(new ClientFilter());
        result.put("data",clients);
        return ReturnUtil.resultSuccess(result);
    }

    /**
     * for checking if the username exist
     * @param username
     * @return
     */
    public Client checkUsername(String username){

        return dao.findByUsername(username);
    }
}
