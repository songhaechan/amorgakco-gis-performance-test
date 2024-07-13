package com.amorgakco.gistest;

import com.amorgakco.gistest.domain.KoreanFood;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KoreanFoodRepository extends JpaRepository<KoreanFood,Long> {
    @Query(value = "select kf from KoreanFood kf " +
            "where st_dwithin(kf.location, :point, :distance,false) = true")
    List<KoreanFood> findByKoreanFoodWithSTDwithin(
            @Param("point") Point point,
            @Param("distance") double distance);
}
