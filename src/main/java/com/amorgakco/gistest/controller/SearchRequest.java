package com.amorgakco.gistest.controller;

import lombok.Getter;

@Getter
public class SearchRequest {
    private double longitude;
    private double latitude;
    private double distance;
}
