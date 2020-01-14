package com.wxxtfxrmx.spritzreader.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.SpritzActivity
import com.wxxtfxrmx.spritzreader.navigation.GlobalNavigator
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import java.lang.IllegalArgumentException

class SpritzActivityInjector(): Application.ActivityLifecycleCallbacks {

    private lateinit var navigator: Navigator

    override fun onActivityPaused(activity: Activity) {
        //ignore
    }

    override fun onActivityStarted(activity: Activity) {
        val supportActivity = activity as AppCompatActivity

        navigator = GlobalNavigator(activity.supportFragmentManager, R.id.content)

        when(activity) {
            is SpritzActivity -> activity.applyDependencies(navigator)
            else -> throw IllegalArgumentException("Activity $activity is not supported by service locator mechanism")
        }
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


    private fun SpritzActivity.applyDependencies(navigator: Navigator) {
        this.navigator = navigator
    }
}