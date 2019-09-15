package com.example.weather.app.activities.main.presenter;

import com.example.weather.data.DB.cityUser.CityUser;

import java.util.List;

public interface iPresenterMainActivity {

    void setCityUser(List<CityUser> list);

    void setProgress(int i);

    void onCreatedDB();
}
