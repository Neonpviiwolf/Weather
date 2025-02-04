package com.example.weather.data.dagger.component;

import com.example.weather.app.activities.findCity.model.listOldCity.ModelListOldCity;
import com.example.weather.app.activities.findCity.model.searchCity.ModelFindCity;
import com.example.weather.app.activities.findCity.presenter.PresenterFindCity;
import com.example.weather.app.activities.listCity.model.findItem.ModelFindListCity;
import com.example.weather.app.activities.listCity.model.removeItem.ModelRemoveItem;
import com.example.weather.app.activities.main.model.addOldChoiceCity.AddOldChoiceCity;
import com.example.weather.app.activities.main.model.doViewModel.DoViewModel;
import com.example.weather.app.activities.main.model.onFirstStart.OnFirstStartModel;
import com.example.weather.app.fragments.weatherCity.model.ModelWeatherCity;
import com.example.weather.app.fragments.weatherCity.model.ReturnTypeWeather;
import com.example.weather.data.dagger.module.MainAppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainAppModule.class})
public interface MainAppComponent {

    void inject(ModelFindCity app);

    void inject(AddOldChoiceCity app);

    void inject(DoViewModel app);

    void inject(PresenterFindCity app);

    void inject(ModelWeatherCity app);

    void inject(ReturnTypeWeather app);

    void inject(OnFirstStartModel app);

    void inject(ModelFindListCity app);

    void inject(ModelRemoveItem app);

    void inject(ModelListOldCity app);
}