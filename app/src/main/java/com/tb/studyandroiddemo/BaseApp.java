package com.tb.studyandroiddemo;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {
    public static Context context;
    public static BaseApp baseApp;
    public static String packageName;
    public String processName;
    public static String getCurrentPackageName(){
        return getCurrentPackageName(context);
    }

    public static BaseApp getBaseApp(){
        return baseApp;
    }


    public static Context getContext(){
        return context;
    }
    private static String getCurrentPackageName(Context context) {
        if (packageName.isEmpty()){
            packageName = context.getPackageName();
        }
        return packageName;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        baseApp = this;
//        if (AppPackageFilesManager.isNotEmpty()){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
//                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
//            }
//            return;
//        }
//        SharedPreferenceUtils.setInstallTime((Context) this);
//        System.currentTimeMillis();
//        ExecutorUtils.initExecutor();
////        ExecutorUtils.submit()
    }
}
