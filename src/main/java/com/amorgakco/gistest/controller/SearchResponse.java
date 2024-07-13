package com.amorgakco.gistest.controller;

import com.amorgakco.gistest.domain.KoreanFood;
import lombok.Getter;

@Getter
public class SearchResponse {
    private String name;
    private String address;
    private String location;

    public SearchResponse(KoreanFood koreanFood){
        this.name = koreanFood.getName();
        this.address = koreanFood.getAddress();
        this.location = koreanFood.getLocation().getLocation().toString();
    }
}
