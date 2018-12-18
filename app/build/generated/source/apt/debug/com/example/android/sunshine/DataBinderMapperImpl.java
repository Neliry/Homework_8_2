package com.example.android.sunshine;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.example.android.sunshine.databinding.ActivityDetailBindingImpl;
import com.example.android.sunshine.databinding.ActivityDetailBindingLandImpl;
import com.example.android.sunshine.databinding.ExtraWeatherDetailsBindingImpl;
import com.example.android.sunshine.databinding.PrimaryWeatherInfoBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYDETAIL = 1;

  private static final int LAYOUT_EXTRAWEATHERDETAILS = 2;

  private static final int LAYOUT_PRIMARYWEATHERINFO = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.sunshine.R.layout.activity_detail, LAYOUT_ACTIVITYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.sunshine.R.layout.extra_weather_details, LAYOUT_EXTRAWEATHERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.sunshine.R.layout.primary_weather_info, LAYOUT_PRIMARYWEATHERINFO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYDETAIL: {
          if ("layout-land/activity_detail_0".equals(tag)) {
            return new ActivityDetailBindingLandImpl(component, view);
          }
          if ("layout/activity_detail_0".equals(tag)) {
            return new ActivityDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_EXTRAWEATHERDETAILS: {
          if ("layout/extra_weather_details_0".equals(tag)) {
            return new ExtraWeatherDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for extra_weather_details is invalid. Received: " + tag);
        }
        case  LAYOUT_PRIMARYWEATHERINFO: {
          if ("layout/primary_weather_info_0".equals(tag)) {
            return new PrimaryWeatherInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for primary_weather_info is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout-land/activity_detail_0", com.example.android.sunshine.R.layout.activity_detail);
      sKeys.put("layout/activity_detail_0", com.example.android.sunshine.R.layout.activity_detail);
      sKeys.put("layout/extra_weather_details_0", com.example.android.sunshine.R.layout.extra_weather_details);
      sKeys.put("layout/primary_weather_info_0", com.example.android.sunshine.R.layout.primary_weather_info);
    }
  }
}
