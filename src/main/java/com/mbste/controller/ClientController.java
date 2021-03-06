package com.mbste.controller;

import com.mbste.dao.ClientDao;
import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.filters.ClientForm;
import com.mbste.service.ClientService;
import com.mbste.commons.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ClientController
{
    @Autowired
    ClientService clientService;
    @Autowired
    ClientDao dao;
    @PostMapping(value = "/info", produces = "application/json;charset=UTF-8")
    public String getClient(@RequestBody ClientFilter form){
        Map<String,Object> resultMap= new HashMap<>();
        Optional<Client> client=clientService.findById(form.getClientId());
        resultMap.put("data",client);
//        resultMap.put("completed",completed);
//        resultMap.put("pending",pending);
        return ReturnUtil.resultSuccess(resultMap);
    }
    @PostMapping(value = "/createNew", produces = "application/json;charset=UTF-8")
    public String createClient(@RequestBody ClientForm clientForm){
        return clientService.createNewClient(clientForm);
    }
    @PostMapping(value = "/updateinfo", produces = "application/json;charset=UTF-8")
    public String updateClient(@RequestBody ClientForm clientForm){

        return clientService.updateClient(clientForm);
    }
    @PostMapping(value = "/password", produces = "application/json;charset=UTF-8")
    public String changePassword(@RequestBody ClientForm clientForm){
        return clientService.changePassword(clientForm);
    }

    @PostMapping(value = "/profile", produces = "application/json;charset=UTF-8")
    public String changeProfileImage(@RequestBody ClientForm clientForm){
        return clientService.changeProfileImage(clientForm);
    }
    @PostMapping(value = "/all",produces = "application/json;charset=UTF-8")
    public String getAll(){
        return clientService.getAll();
    }
}
