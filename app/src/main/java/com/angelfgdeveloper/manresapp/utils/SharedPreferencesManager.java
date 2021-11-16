package com.angelfgdeveloper.manresapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private SharedPreferencesManager(){
    }

    private static SharedPreferences getSharedPreferences(){
        return MyApp.getContext().getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }

    public static void setStringValue(String dataLabel, String dataValue){
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(dataLabel, dataValue);
        edit.apply();
    }

    public static String getStringValue(String dataLabel){
        return getSharedPreferences().getString(dataLabel, "");
    }

    public static void setBooleanValue(String dataLabel, boolean dataValue){
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(dataLabel, dataValue);
        edit.apply();
    }

    public static boolean getBooleanValue(String dataLabel){
        return getSharedPreferences().getBoolean(dataLabel, false);
    }

    public static void setIntValue(String dataLabel, int dataValue){
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putInt(dataLabel, dataValue);
        edit.apply();
    }

    public static int getIntValue(String dataLabel){
        return getSharedPreferences().getInt(dataLabel, -1);
    }

    public static void removeDataValue(String dataLabel){
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.remove(dataLabel);
        edit.apply();
    }

}
