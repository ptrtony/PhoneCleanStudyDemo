package com.tb.studyandroiddemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {
    public static long installTime = 0L;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences instance(Context context){
        if (sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("application",Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }


//    public static SharedPreferences instance(){
//        return instance(AppGlobal.INSTANCE.get());
//    }

    public static long getInstallTime(Context context){
        if (installTime == 0L){
            installTime = instance(context).getLong("install_time",0L);
        }
        return installTime;
    }

    public static void setInstallTime(Context context){
        if (getInstallTime(context) == 0L){
            installTime = System.currentTimeMillis();
            instance(context).edit().putLong("install_time",installTime).apply();
        }
    }


}
