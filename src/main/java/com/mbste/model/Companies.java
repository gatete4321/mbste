package com.mbste.model;

import java.util.List;

public class Companies
{
    private Integer comp_if;

    private  String compsny_name;

    private List<String> services;

    public Integer getComp_if() {
        return comp_if;
    }

    public void setComp_if(Integer comp_if) {
        this.comp_if = comp_if;
    }

    public String getCompsny_name() {
        return compsny_name;
    }

    public void setCompsny_name(String compsny_name) {
        this.compsny_name = compsny_name;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
