package com.tb.studyandroiddemo;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationMonitorService extends NotificationListenerService {
    public static final List<StatusBarNotificationManager> statusBarNotificationManagers = new CopyOnWriteArrayList<StatusBarNotificationManager>();
    public boolean isCleanJunk;
    public boolean a;
    @TargetApi(24)
    public void onListenerDisconnected() {
        NotificationListenerService.requestRebind(new ComponentName(getApplicationContext(), NotificationMonitorService.class));
    }

    public void onNotificationPosted(StatusBarNotification paramStatusBarNotification) {
//        c();
//        if (this.a && d(paramStatusBarNotification)) {
//            a.a((Context)this);
//            a.g((Context)this);
//        }
    }

    public void onNotificationRemoved(StatusBarNotification paramStatusBarNotification) {
        super.onNotificationRemoved(paramStatusBarNotification);
    }



    public final void cleanJunk() {
        if (this.a)
            return;
        isCleanJunk = NotificationSharedPreferenceUtil.isNotificationClean(this);
        statusBarNotificationManagers.clear();
        if (isCleanJunk)
            executorCleanJunk();
        this.a = true;
    }


    public final void executorCleanJunk(){
        try{
            StatusBarNotification[] arrayOfStatusBarNotification = getActiveNotifications();
        }catch (RuntimeException runtimeException){
            runtimeException = null;
        }
        StatusBarNotificationManager[] arrs =getStatusBarNotifications(this);


    }


    public static StatusBarNotificationManager[] getStatusBarNotifications(Context paramContext) {
        String str = getNotificationCleanSerialize(paramContext);
        ByteArrayInputStream byteArrayInputStream = null;
        if (TextUtils.isEmpty(str))
            return null;
        Exception exc;
        try {
            String str1 = URLDecoder.decode(str, StandardCharsets.UTF_8.name());
            byteArrayInputStream = new ByteArrayInputStream(str1.getBytes());
        } catch (Exception exception1) {
            exc = exception1;
        } finally {
            str = null;
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream1 = byteArrayInputStream2;
            try {
                Objects.requireNonNull(byteArrayInputStream1);
                ((ByteArrayInputStream)byteArrayInputStream1).close();
            } catch (Exception exception) {
                exc = exception;
            }
        }
        try {
//            Objects.requireNonNull(exc);
//            byteArrayInputStream2.close();
        } catch (Exception exception1) {}
        try {
            Objects.requireNonNull(str);

        } catch (Exception exception1) {}
        return null;
    }

    public static String getNotificationCleanSerialize(Context paramContext) {
        return paramContext.getSharedPreferences("notif_clean_sp", 0).getString("notif_clean_serialize", null);
    }


//    public final boolean d(StatusBarNotification paramStatusBarNotification) {
//        String str = paramStatusBarNotification.getPackageName();
//        if (!e || !paramStatusBarNotification.isClearable() || g.d((Context)this).contains(str) || BaseApp.b((Context)this).equals(str))
//            return false;
//        int i = this.b;
//        this.b = i + 1;
//        b b = new b((Context)this, paramStatusBarNotification, i);
//        Iterator<b> iterator = d.iterator();
//        while (true) {
//            boolean bool = iterator.hasNext();
//            boolean bool1 = true;
//            if (bool) {
//                b b1 = iterator.next();
//                bool = b1.c.equals(b.c);
//                if (b1.b == b.b) {
//                    i = 1;
//                } else {
//                    i = 0;
//                }
//                if (Math.abs(b.h - b1.h) >= 1000L)
//                    bool1 = false;
//                if (bool && i != 0 && bool1)
//                    return false;
//                continue;
//            }
//            List<b> list = d;
//            if (list.size() > 0 && ((b)list.get(0)).a == 0) {
//                list.add(1, b);
//            } else {
//                list.add(0, b);
//            }
//            i = list.size();
//            if (i > 100)
//                list.subList(100, i).clear();
//            if (this.c == null)
//                this.c = a.b((Context)this);
//            Intent intent = new Intent("cherry.core.notification.monitor.update");
//            this.c.d(intent);
//            f(paramStatusBarNotification);
//            return true;
//        }
//    }
}
