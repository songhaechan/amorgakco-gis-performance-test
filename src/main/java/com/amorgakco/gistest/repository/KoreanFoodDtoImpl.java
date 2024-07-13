package com.amorgakco.gistest.repository;

public class KoreanFoodDtoImpl implements KoreanFoodDto {
    private Long id;
    private String name;
    private String address;
    private String point;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPoint() {
        return point;
    }
}
