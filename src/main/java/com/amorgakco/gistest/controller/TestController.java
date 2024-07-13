package com.amorgakco.gistest.controller;

import com.amorgakco.gistest.repository.KoreanFoodDto;
import com.amorgakco.gistest.repository.KoreanFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final KoreanFoodRepository koreanFoodRepository;

    @GetMapping("/mysql/st_distance_sphere")
    public List<KoreanFoodDto> getLocationsBySphere(@RequestParam int distance){
        return koreanFoodRepository.findByST_Distance_Sphere(distance);
    }

    @GetMapping("/mysql/st_within")
    public List<KoreanFoodDto> getLocationsByWithin(@RequestParam int distance){
        return koreanFoodRepository.findByST_Within(distance);
    }
}
