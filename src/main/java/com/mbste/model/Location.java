package com.mbste.model;

/**
 * Created by gatete Rugamba
 * on 3/19/2019
 * Make it work, make it right, make it fast.
 */
public class Location {

    // location id
    private Integer locationId;

    //location province
    private Integer provinceId;

    //location district
    private Integer districtId;

    //location sector
    private String locationName;


    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }


    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
