package com.amorgakco.gistest;

import com.google.common.geometry.S1Angle;
import com.google.common.geometry.S2Cap;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2CellUnion;
import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2LatLngRect;
import com.google.common.geometry.S2Point;
import com.google.common.geometry.S2RegionCoverer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class GoogleS2Test {

    @Test
    void searchByCircle() {
        S2LatLng latLng = S2LatLng.fromDegrees(37.5162149,127.0195806);
        S2Point point = latLng.toPoint();
        S1Angle s1Angle = new S1Angle(new S2Point(37.462507,126.9261294, 0), new S2Point(37.5972353,127.0859765, 0));
        ArrayList<S2CellId> result = new ArrayList<>();
        S2Cap s2Cap = S2Cap.fromAxisAngle(point, s1Angle);
        S2RegionCoverer.getSimpleCovering(s2Cap,point,14,result);
        List<String> collect = result.stream().map(m -> m.toToken()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    void searchByRect() {
        S2LatLngRect s2LatLngRect = S2LatLngRect.fromPointPair(S2LatLng.fromDegrees(37.5972353, 127.0859765),S2LatLng.fromDegrees(37.462507, 126.9261294));
        S2RegionCoverer coverer = S2RegionCoverer.builder()
                .setMinLevel(14)
                .setMaxLevel(14)
                .setMaxCells(10)
                .build();
        S2CellUnion covering = coverer.getCovering(s2LatLngRect);
        S2CellUnion interiorCovering = coverer.getInteriorCovering(s2LatLngRect);
//        List<String> list = covering.cellIds().stream().map(S2CellId::toToken).toList();
//        System.out.println("list = " + list);
        List<String> list = interiorCovering.cellIds().stream().map(S2CellId::toToken).toList();
        System.out.println("list = " + list);
    }

    @Test
    @DisplayName("")
    void test() {
        S2LatLng northeast = S2LatLng.fromDegrees(37.8044, -122.4091); // 예시로 샌프란시스코의 북동쪽 좌표
        S2LatLng southwest = S2LatLng.fromDegrees(37.7599, -122.4269); // 예시로 샌프란시스코의 남서쪽 좌표

        // S2LatLngRect 생성
        S2LatLngRect rect = S2LatLngRect.fromPointPair(southwest, northeast);

        // S2RegionCoverer 설정
        S2RegionCoverer coverer = S2RegionCoverer.builder()
                .setMinLevel(14)
                .setMaxLevel(14)
                .setMaxCells(10)
                .build();

        // S2 셀 커버링 구하기
        List<String> list = coverer.getCovering(rect).cellIds().stream().map(S2CellId::toToken).toList();
        System.out.println("list = " + list);

    }
}