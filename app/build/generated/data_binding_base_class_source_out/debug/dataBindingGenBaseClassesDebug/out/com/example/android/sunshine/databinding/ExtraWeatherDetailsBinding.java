package com.example.android.sunshine.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ExtraWeatherDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout extraDetails;

  @NonNull
  public final Guideline horizontalMiddle;

  @NonNull
  public final TextView humidity;

  @NonNull
  public final TextView humidityLabel;

  @NonNull
  public final TextView pressure;

  @NonNull
  public final TextView pressureLabel;

  @NonNull
  public final TextView windLabel;

  @NonNull
  public final TextView windMeasurement;

  protected ExtraWeatherDetailsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout extraDetails, Guideline horizontalMiddle,
      TextView humidity, TextView humidityLabel, TextView pressure, TextView pressureLabel,
      TextView windLabel, TextView windMeasurement) {
    super(_bindingComponent, _root, _localFieldCount);
    this.extraDetails = extraDetails;
    this.horizontalMiddle = horizontalMiddle;
    this.humidity = humidity;
    this.humidityLabel = humidityLabel;
    this.pressure = pressure;
    this.pressureLabel = pressureLabel;
    this.windLabel = windLabel;
    this.windMeasurement = windMeasurement;
  }

  @NonNull
  public static ExtraWeatherDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ExtraWeatherDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ExtraWeatherDetailsBinding>inflate(inflater, com.example.android.sunshine.R.layout.extra_weather_details, root, attachToRoot, component);
  }

  @NonNull
  public static ExtraWeatherDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ExtraWeatherDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ExtraWeatherDetailsBinding>inflate(inflater, com.example.android.sunshine.R.layout.extra_weather_details, null, false, component);
  }

  public static ExtraWeatherDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ExtraWeatherDetailsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ExtraWeatherDetailsBinding)bind(component, view, com.example.android.sunshine.R.layout.extra_weather_details);
  }
}
