package com.tb.studyandroiddemo

import android.app.Application
import java.lang.Exception

object AppGlobal {
    var application: Application? = null
    get() {
        if (field == null) {
            field = try {
                Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as Application
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

        return field
    }


    fun get(): Application? {
        if (application == null) {
            try {
                application = Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as Application
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return application
    }
}