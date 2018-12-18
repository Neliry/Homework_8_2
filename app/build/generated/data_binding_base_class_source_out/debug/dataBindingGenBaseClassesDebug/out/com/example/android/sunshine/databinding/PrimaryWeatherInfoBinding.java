package com.example.android.sunshine.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class PrimaryWeatherInfoBinding extends ViewDataBinding {
  @NonNull
  public final TextView date;

  @NonNull
  public final TextView highTemperature;

  @NonNull
  public final Guideline horizontalMiddle;

  @NonNull
  public final TextView lowTemperature;

  @NonNull
  public final TextView weatherDescription;

  @NonNull
  public final ImageView weatherIcon;

  protected PrimaryWeatherInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView date, TextView highTemperature, Guideline horizontalMiddle,
      TextView lowTemperature, TextView weatherDescription, ImageView weatherIcon) {
    super(_bindingComponent, _root, _localFieldCount);
    this.date = date;
    this.highTemperature = highTemperature;
    this.horizontalMiddle = horizontalMiddle;
    this.lowTemperature = lowTemperature;
    this.weatherDescription = weatherDescription;
    this.weatherIcon = weatherIcon;
  }

  @NonNull
  public static PrimaryWeatherInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PrimaryWeatherInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PrimaryWeatherInfoBinding>inflate(inflater, com.example.android.sunshine.R.layout.primary_weather_info, root, attachToRoot, component);
  }

  @NonNull
  public static PrimaryWeatherInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PrimaryWeatherInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PrimaryWeatherInfoBinding>inflate(inflater, com.example.android.sunshine.R.layout.primary_weather_info, null, false, component);
  }

  public static PrimaryWeatherInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PrimaryWeatherInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PrimaryWeatherInfoBinding)bind(component, view, com.example.android.sunshine.R.layout.primary_weather_info);
  }
}
