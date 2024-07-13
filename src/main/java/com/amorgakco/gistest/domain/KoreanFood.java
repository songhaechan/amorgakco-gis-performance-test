package com.amorgakco.gistest.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "korean_food")
public class KoreanFood {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Embedded
    private Location location;

}
