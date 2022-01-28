package com.tb.studyandroiddemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;

import java.io.Serializable;

public class StatusBarNotificationManager implements Serializable {
    public int notificationId;
    private String packageName;
    private int id;
    private String key;
    private long postTime;
    private PendingIntent contentIntent;
    private String title;
    private String text;

    public StatusBarNotificationManager(Context context, StatusBarNotification statusBarNotification, int paramInt){
        this.notificationId = paramInt;
        Notification notification = statusBarNotification.getNotification();
        packageName = statusBarNotification.getPackageName();
        id = statusBarNotification.getId();
        key = getKey(statusBarNotification);
        postTime = statusBarNotification.getPostTime();
        contentIntent = notification.contentIntent;
        Bundle bundle = notification.extras;
        title = bundle.getString("android.title");
        text = bundle.getString("android.text");
        CharSequence tickerText = notification.tickerText;
        if (tickerText != null && tickerText.length() != 0){
            if (this.title == null) {
                this.title = tickerText.toString();
            } else if (this.text == null) {
                this.text = tickerText.toString();
            }
        }
        tickerText = title;
        if (tickerText == null){
            this.title = getPackageLabel(context,packageName);
        }else if (text == null){
            this.text = (String)tickerText;
            this.title = getPackageLabel(context,packageName);
        }
        String str = title;
        if (str != null && str.length() > 51)
            this.title = String.format("%s", new Object[] { this.title.substring(0, 50) });
                    str = this.text;
        if (str != null && str.length() > 101)
            this.text = String.format("%s", new Object[] { this.text.substring(0, 100) });
    }


    public static String getPackageLabel(Context paramContext, String packageName) {
        try {
            PackageManager packageManager = paramContext.getPackageManager();
            return packageManager.getApplicationLabel((packageManager.getPackageInfo(packageName, 0)).applicationInfo).toString();
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            return "";
        }
    }


    public final String getKey(StatusBarNotification paramStatusBarNotification) {
        return (Build.VERSION.SDK_INT < 20) ? null : paramStatusBarNotification.getKey();
    }
}
