package com.amorgakco.gistest.controller;

import com.amorgakco.gistest.KoreanFoodRepository;
import com.amorgakco.gistest.domain.KoreanFood;
import com.amorgakco.gistest.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final KoreanFoodRepository koreanFoodRepository;
    @GetMapping("/posgres/st_dwithin")
    public List<SearchResponse> getKoreanFoodLocation(@RequestBody SearchRequest searchRequest){
        Location location = new Location(searchRequest.getLatitude(), searchRequest.getLongitude());
        double distance = searchRequest.getDistance();
        List<SearchResponse> collect = koreanFoodRepository.findByKoreanFoodWithSTDwithin(location.getLocation(), distance)
                .stream()
                .map(SearchResponse::new)
                .collect(Collectors.toList());
        return collect;
    }
}
