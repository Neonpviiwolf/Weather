package com.example.weather.data.DB.cityUserList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;

@Entity(tableName = "city_user_list")
public class CityUserList {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public long id_server;

    @ColumnInfo(name = "name_city")
    public String nameCity;

    @Builder
    public CityUserList(long id_server, String nameCity) {
        this.id_server = id_server;
        this.nameCity = nameCity;
    }
}