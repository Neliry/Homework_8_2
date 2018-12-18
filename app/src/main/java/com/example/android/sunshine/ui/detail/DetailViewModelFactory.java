package com.example.android.sunshine.ui.detail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.example.android.sunshine.data.database.WeatherEntry;

import com.example.android.sunshine.data.SunshineRepository;

import java.util.Date;

/**
 * Factory method that allows us to create a ViewModel with a constructor that takes a
 * {@link SunshineRepository} and an ID for the current {@link WeatherEntry}
 */
public class DetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SunshineRepository mRepository;
    private final Date mDate;

    public DetailViewModelFactory(SunshineRepository repository, Date date) {
        this.mRepository = repository;
        this.mDate = date;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new DetailActivityViewModel(mRepository, mDate);
    }
}