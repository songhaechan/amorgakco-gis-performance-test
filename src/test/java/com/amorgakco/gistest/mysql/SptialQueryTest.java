package com.amorgakco.gistest.mysql;

import com.amorgakco.gistest.domain.KoreanFood;
import com.amorgakco.gistest.domain.Location;
import com.amorgakco.gistest.repository.KoreanFoodDto;
import com.amorgakco.gistest.repository.KoreanFoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SptialQueryTest {

    @Autowired
    KoreanFoodRepository koreanFoodRepository;

    @Test
    void test() {
        long start = System.nanoTime();
        Location location = new Location(37.5162873d,127.0200228d);
        List<KoreanFoodDto> foods = koreanFoodRepository.findByST_Distance_Sphere(1000);
        long end = System.nanoTime();
        long duration = end - start;
        double runningTimeMillis = duration / 1_000_000.0;
        System.out.println("Size : "+foods.size());
        System.out.println("Query : " + runningTimeMillis);
    }

}
