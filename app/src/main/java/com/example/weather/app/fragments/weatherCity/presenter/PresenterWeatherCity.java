package com.example.weather.app.fragments.weatherCity.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.weather.app.fragments.weatherCity.model.ModelWeatherCity;
import com.example.weather.app.fragments.weatherCity.model.ReturnTypeWeather;
import com.example.weather.app.fragments.weatherCity.model.iModelWeatherCity;
import com.example.weather.app.fragments.weatherCity.model.iReturnTypeWeather;
import com.example.weather.app.fragments.weatherCity.view.ViewWeatherCity;
import com.example.weather.app.fragments.weatherCity.wrapper.WrapperData;
import com.example.weather.data.network.data.GetPostDataWeather;

@InjectViewState
public class PresenterWeatherCity extends MvpPresenter<ViewWeatherCity> implements iPresenterWeatherCity {

    private iModelWeatherCity model;
    private iReturnTypeWeather returnTypeWeather;
    private long idWeather;

    public PresenterWeatherCity() {
        model = new ModelWeatherCity(this);
        returnTypeWeather = new ReturnTypeWeather();
    }

    public void setIdWeather(long idWeather) {
        this.idWeather = idWeather;
        model.setIdWeather(idWeather);
    }

    @Override
    public void setDataWeather(GetPostDataWeather getPostDataWeather) {
        getViewState().goneUpdateData();

        String temp = String.valueOf((int) getPostDataWeather.getMain().getTemp());
        String typeWeather = getPostDataWeather.getWeather().get(0).getDescription().toUpperCase();

        String typeWeatherIcon = returnTypeWeather
                .getTypeWeather(getPostDataWeather.getWeather().get(0).getId(),
                        getPostDataWeather.getSys().getSunrise() * 1000,
                        getPostDataWeather.getSys().getSunset() * 1000);

        String speedWind = String.valueOf(getPostDataWeather.getWind().getSpeed());
        String humidity = String.valueOf(getPostDataWeather.getMain().getHumidity());
        String pressure = String.valueOf((int) getPostDataWeather.getMain().getPressure());

        WrapperData wrapperData = WrapperData
                .builder()
                .nameCity(getPostDataWeather.getName())
                .typeWeather(typeWeather)
                .temp(temp)
                .typeWeatherIcon(typeWeatherIcon)
                .speedWind(speedWind)
                .degWind(getPostDataWeather.getWind().getDeg())
                .pressure(pressure)
                .humidity(humidity)
                .build();

        getViewState().setData(wrapperData);
    }

    @Override
    public void setMotionSize(int height, int y1, int y2) {
        if (y2 - y1 > height * 0.1) {
            getViewState().showUpdateData();
            model.setIdWeather(idWeather);
        }
    }
}