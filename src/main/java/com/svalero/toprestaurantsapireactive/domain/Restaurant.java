package com.svalero.toprestaurantsapireactive.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(value = "restaurants")
public class Restaurant {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String timetable;
    @Field
    private String type;
    @Field
    private double reservePrice;
    @Field
    private boolean veganMenu;
    @Field
    private String website;
    @Field
    private double longitude;
    @Field
    private double latitude;
}
