package com.example.weather.data.network.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostMain {
    private float temp;
    /*давление*/
    private float pressure;
    /*влажность*/
    private int humidity;
}
