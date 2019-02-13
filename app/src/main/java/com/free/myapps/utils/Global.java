package com.free.myapps.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jonathan on 13/02/2019.
 */

public class Global {
    public static String KEY_EMAIL = "Email";
    public static String KEY_PASS = "Password";

    public static void editEmail(Context context, String email) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public static String getEmail(Context context) {
        String email = PreferencesManager.getInstance(context).getString(KEY_EMAIL,"");
        return email;
    }

    public static void editPassword(Context context, String pass) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_PASS, pass);
        editor.apply();
    }

    public static String getPassword(Context context) {
        String pass = PreferencesManager.getInstance(context).getString(KEY_PASS,"");
        return pass;
    }

}
