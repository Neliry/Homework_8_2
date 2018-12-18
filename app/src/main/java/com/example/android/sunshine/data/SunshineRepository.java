package com.example.android.sunshine.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.android.sunshine.AppExecutors;
import com.example.android.sunshine.data.database.ListWeatherEntry;
import com.example.android.sunshine.data.database.WeatherDao;
import com.example.android.sunshine.data.database.WeatherEntry;
import com.example.android.sunshine.data.network.WeatherNetworkDataSource;
import com.example.android.sunshine.utilities.SunshineDateUtils;

import java.util.Date;
import java.util.List;

public class SunshineRepository {
    private static final String LOG_TAG = SunshineRepository.class.getSimpleName();

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static SunshineRepository sInstance;
    private final WeatherDao mWeatherDao;
    private final WeatherNetworkDataSource mWeatherNetworkDataSource;
    private final AppExecutors mExecutors;
    private boolean mInitialized = false;

    private SunshineRepository(WeatherDao weatherDao,
                               WeatherNetworkDataSource weatherNetworkDataSource,
                               AppExecutors executors) {
        mWeatherDao = weatherDao;
        mWeatherNetworkDataSource = weatherNetworkDataSource;
        mExecutors = executors;

        // As long as the repository exists, observe the network LiveData.
        // If that LiveData changes, update the database.
        LiveData<WeatherEntry[]> networkData = mWeatherNetworkDataSource.getCurrentWeatherForecasts();
        networkData.observeForever(newForecastsFromNetwork -> {
            mExecutors.diskIO().execute(() -> {
                deleteOldData();
                // Insert our new weather data into Sunshine's database
                mWeatherDao.bulkInsert(newForecastsFromNetwork);
                Log.d(LOG_TAG, "New values inserted");
            });
        });
    }

    public synchronized static SunshineRepository getInstance(
            WeatherDao weatherDao, WeatherNetworkDataSource weatherNetworkDataSource,
            AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new SunshineRepository(weatherDao, weatherNetworkDataSource,
                        executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    private synchronized void initializeData() {

        // Only perform initialization once per app lifetime. If initialization has already been
        // performed, we have nothing to do in this method.
        if (mInitialized) return;
        mInitialized = true;

        mWeatherNetworkDataSource.scheduleRecurringFetchWeatherSync();

        mExecutors.diskIO().execute(() -> {
            if (isFetchNeeded()) {
                startFetchWeatherService();
            }
        });
    }

    public LiveData<List<ListWeatherEntry>> getCurrentWeatherForecasts() {
        initializeData();
        Date today = SunshineDateUtils.getNormalizedUtcDateForToday();
        return mWeatherDao.getCurrentWeatherForecasts(today);
    }

    public LiveData<WeatherEntry> getWeatherByDate(Date date) {
        initializeData();
        return mWeatherDao.getWeatherByDate(date);
    }

    private void deleteOldData() {
        Date today = SunshineDateUtils.getNormalizedUtcDateForToday();
        mWeatherDao.deleteOldWeather(today);
    }

    private boolean isFetchNeeded() {
        Date today = SunshineDateUtils.getNormalizedUtcDateForToday();
        int count = mWeatherDao.countAllFutureWeather(today);
        return (count < WeatherNetworkDataSource.NUM_DAYS);
    }

    private void startFetchWeatherService() {
        mWeatherNetworkDataSource.startFetchWeatherService();
    }

}