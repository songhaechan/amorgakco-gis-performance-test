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
    @Column(columnDefinition = "geometry(POINT, 4326)", name = "location")
    private Point location;

    public Location(Double latitude, Double longitude) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        location = geometryFactory.createPoint(new Coordinate(longitude, latitude));
    }
}
