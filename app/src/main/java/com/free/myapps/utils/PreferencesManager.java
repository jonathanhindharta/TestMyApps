package com.free.myapps.utils;

/**
 * Created by JonathanEKSI on 12/02/2019.
 */
//singleton utk preference
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.Set;

public class PreferencesManager {
    private static PreferencesManager mInstance;
    private Context mContext;
    private SharedPreferences mMyPreferences;

    private PreferencesManager() {
    }

    public static PreferencesManager getInstance(Context ctx) {
        if (mInstance == null)
            mInstance = new PreferencesManager();
        if (mInstance.mContext == null && mInstance.mMyPreferences == null) {
            mInstance.Initialize(ctx);
        }
        return mInstance;
    }

    public void Initialize(Context ctxt) {
        mContext = ctxt;
        mMyPreferences = PreferenceManager
                .getDefaultSharedPreferences(mContext);
    }

    public void Initialize(Context ctxt, String prefName) {
        mContext = ctxt;
        mMyPreferences = ctxt.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, boolean value) {
        Editor e = mMyPreferences.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public void putFloat(String key, Float value) {
        Editor e = mMyPreferences.edit();
        e.putFloat(key, value);
        e.commit();
    }

    public void putInt(String key, int value) {
        Editor e = mMyPreferences.edit();
        e.putInt(key, value);
        e.commit();
    }

    public void putLong(String key, Long value) {
        Editor e = mMyPreferences.edit();
        e.putLong(key, value);
        e.commit();
    }

    public void putString(String key, String value) {
        Editor e = null;
        e = mMyPreferences.edit();
        e.putString(key, value);
        e.commit();
    }

    public void putStringSet(String key, Set<String> value) {
        Editor e = mMyPreferences.edit();
        e.putStringSet(key, value);
        e.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mMyPreferences.getBoolean(key, defValue);
    }

    public Float getFloat(String key, Float defValue) {
        return mMyPreferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mMyPreferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return mMyPreferences.getLong(key, defValue);
    }

    public String getString(String key, String defValue) {
        return mMyPreferences.getString(key, defValue);
    }

    public Set<String> getStringSet(String key, Set<String> defValue) {
        return mMyPreferences.getStringSet(key, defValue);
    }
}