package com.wxxtfxrmx.spritzreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SpritzActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        dispatchingAndroidInjector

    @Inject
    lateinit var mainRouter: MainRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spritz_activity)
        mainRouter.openTabsScreen()
    }
}