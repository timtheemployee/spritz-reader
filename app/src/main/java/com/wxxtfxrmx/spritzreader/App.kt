package com.wxxtfxrmx.spritzreader

import android.app.Application
import com.wxxtfxrmx.spritzreader.di.SpritzActivityInjector

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(
            SpritzActivityInjector()
        )
    }
}