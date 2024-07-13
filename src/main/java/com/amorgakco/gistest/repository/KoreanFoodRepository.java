package com.amorgakco.gistest.repository;

import com.amorgakco.gistest.domain.KoreanFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KoreanFoodRepository extends JpaRepository<KoreanFood,Long> {
//    ST_Distance_Sphere() 사용
    @Query(value = "select " +
            "id,name,address, St_AsText(point) as point" +
            " from korean_food as kf" +
            " where ST_Distance_Sphere(kf.point,ST_PointFromText('POINT(37.5162149 127.0195806)',4326)) < :distance",nativeQuery = true)
    List<KoreanFoodDto> findByST_Distance_Sphere(@Param("distance") int distance);

    @Query(value = "select " +
            "id,name,address,St_AsText(point) as point" +
            " from korean_food as kf" +
            " where ST_Within(point,getDistanceMBR(ST_PointFromText('POINT(37.5162149 127.0195806)',4326),:distance/1000)) " +
            "and ST_Distance_Sphere(kf.point,ST_PointFromText('POINT(37.5162149 127.0195806)',4326)) < :distance",nativeQuery = true)
    List<KoreanFoodDto> findByST_Within(@Param("distance") int distance);
 }

