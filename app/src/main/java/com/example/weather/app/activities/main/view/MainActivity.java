package com.example.weather.app.activities.main.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.weather.R;
import com.example.weather.app.activities.findCity.view.FindCity;
import com.example.weather.app.activities.listCity.view.ListCity;
import com.example.weather.app.activities.main.presenter.PresenterMainActivity;
import com.example.weather.app.adapter.TabsFragmentPageAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements ViewMainActivity {

    @InjectPresenter PresenterMainActivity presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.ib_show_city) ImageButton ibShowCity;
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.layout_progress_bar) LinearLayout layoutProgressBar;
    @BindView(R.id.appBarLayout) AppBarLayout appBarLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    private TabsFragmentPageAdapter adapter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        adapter = new TabsFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        ibShowCity.setOnClickListener(v -> presenter.showCity());

        layoutProgressBar.setVisibility(View.VISIBLE);
        appBarLayout.setVisibility(View.GONE);
    }

    @Override
    public void doLoader() {
        layoutProgressBar.setVisibility(View.GONE);
        appBarLayout.setVisibility(View.VISIBLE);
        adapter.setListCity(presenter.getListCity());
    }

    @Override
    public void updateViewPager() {
        adapter.updateListCity();
    }

    @Override
    public void showFindCity() {
        Intent intent = new Intent(getApplicationContext(), FindCity.class);
        startActivity(intent);
    }

    @Override
    public void showListCity() {
        Intent intent = new Intent(getApplicationContext(), ListCity.class);
        startActivity(intent);
    }

    @Override
    public void showPositionViewPager(int position) {
        adapter.updateListCity();
        viewPager.setCurrentItem(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }
}