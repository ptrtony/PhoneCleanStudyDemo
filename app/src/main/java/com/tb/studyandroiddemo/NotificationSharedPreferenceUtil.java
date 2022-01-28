package com.tb.studyandroiddemo;

import android.content.Context;
import android.content.SharedPreferences;

public class NotificationSharedPreferenceUtil {
    public static SharedPreferences instance;
    public static SharedPreferences getSharedPreferences() {
        if (instance == null)
            instance = BaseApp.getBaseApp().getSharedPreferences("settings", 0);
        return instance;
    }



    public static boolean isNotificationClean(Context paramContext) {
        return paramContext.getSharedPreferences("settings", 0).getBoolean("notif_clean", true);
    }


//    public static boolean cleanJunk() {
//        return SharedPreferenceUtils.instance().getBoolean("notif_clean", true);
//    }
//
//    public static void setNotificationCleanJunk(boolean paramBoolean) {
//        SharedPreferenceUtils.instance().edit().putBoolean("notif_clean", paramBoolean).apply();
//    }
}
