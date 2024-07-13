package com.amorgakco.gistest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

@Embeddable
@NoArgsConstructor
@Getter
public class Location {
    @Column(columnDefinition = "POINT SRID 4326")
    private Point point;

    public Location(Double latitude, Double longitude) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        point = geometryFactory.createPoint(new Coordinate(longitude, latitude));
    }
}
