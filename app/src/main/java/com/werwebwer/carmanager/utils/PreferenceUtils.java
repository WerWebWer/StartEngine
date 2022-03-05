package com.werwebwer.carmanager.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import com.werwebwer.carmanager.R;

public class PreferenceUtils {
    private SharedPreferences mSharedPreferences;
    private Context mContext;

    public PreferenceUtils(@NonNull Context context) {
        mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Nullable
    public String getNumber() {
        return mSharedPreferences.getString(mContext.getString(R.string.key_number), null);
    }

    @Nullable
    public String getCodeStartEngine() {
        return mSharedPreferences.getString(mContext.getString(R.string.key_start_engine), null);
    }

    public boolean isValidData() {
        return TextUtils.isDataValid(getNumber(), getCodeStartEngine());
    }

    public boolean isNumberValid() {
        return TextUtils.isNumber(getNumber());
    }

    public boolean isCodeStartEngineValid() {
        return TextUtils.isCode(getCodeStartEngine());
    }
}
