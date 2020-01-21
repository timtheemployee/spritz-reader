package com.wxxtfxrmx.spritzreader.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.wxxtfxrmx.spritzreader.navigation.Navigator

class SpritzActivityInjector: Application.ActivityLifecycleCallbacks {

    private lateinit var navigator: Navigator

    override fun onActivityPaused(activity: Activity) {
        //ignore
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        //ignored
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        //ignored
    }

    override fun onActivityStopped(activity: Activity) {
        //ignored
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        //ignored
    }

    override fun onActivityResumed(activity: Activity) {
        //ignored
    }

}