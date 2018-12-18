package com.example.android.sunshine.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ActivityDetailBinding extends ViewDataBinding {
  @NonNull
  public final ExtraWeatherDetailsBinding extraDetails;

  @NonNull
  public final PrimaryWeatherInfoBinding primaryInfo;

  protected ActivityDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ExtraWeatherDetailsBinding extraDetails,
      PrimaryWeatherInfoBinding primaryInfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.extraDetails = extraDetails;
    setContainedBinding(this.extraDetails);;
    this.primaryInfo = primaryInfo;
    setContainedBinding(this.primaryInfo);;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, null, false, component);
  }

  public static ActivityDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDetailBinding)bind(component, view, com.example.android.sunshine.R.layout.activity_detail);
  }
}
