package com.amorgakco.gistest;

import com.amorgakco.gistest.domain.KoreanFood;
import com.amorgakco.gistest.repository.KoreanFoodDto;
import com.amorgakco.gistest.repository.KoreanFoodRepository;
import com.google.common.geometry.S1Angle;
import com.google.common.geometry.S2Cap;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
import com.google.common.geometry.S2RegionCoverer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleS2Service {

    private final KoreanFoodRepository koreanFoodRepository;

    public List<KoreanFood> search(
            double southWestLat,
            double southWestLon,
            double northEastLat,
            double northEastLon,
            double currentLat,
            double currentLon
    ){
        S2LatLng latLng = S2LatLng.fromDegrees(currentLat,currentLon);
        S2Point point = latLng.toPoint();

        S1Angle s1Angle = new S1Angle(new S2Point(southWestLat,southWestLon, 0), new S2Point(northEastLat,northEastLon, 0));
        S2Cap s2Cap = S2Cap.fromAxisAngle(point,s1Angle);
        ArrayList<S2CellId> result = new ArrayList<>();

        S2RegionCoverer.getSimpleCovering(s2Cap,point,14,result);
        List<String> tokens = result.stream().map(S2CellId::toToken).toList();
        System.out.println("tokens = " + tokens);
        List<KoreanFood> byTokens = koreanFoodRepository.findByTokens(tokens);
        System.out.println("byTokens = " + byTokens);
        return byTokens;
    }

}

