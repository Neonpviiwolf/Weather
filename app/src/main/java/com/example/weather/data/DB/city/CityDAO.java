package com.example.weather.data.DB.city;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;

@Dao
public interface CityDAO {
    @Insert
    void add(City city);

    @Insert
    void addAll(List<City> cities);

    @Query("Delete from city where id =:id")
    void delete(long id);


    @Query("Select COUNT(*) FROM city")
    Maybe<Integer> getCount();

    @Query("Select * from city where city_en like :str limit 20")
    Observable<List<City>> getList(String str);
}