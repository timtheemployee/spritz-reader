package com.wxxtfxrmx.spritzreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.spritzreader.di.TabsFragmentInjector
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouter
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouterImpl
import com.wxxtfxrmx.spritzreader.navigation.tabs.MainNavigator

class SpritzActivity : AppCompatActivity() {

    private val mainNavigator by lazy {
        MainNavigator(supportFragmentManager, R.id.content)
    }

    private val mainRouter: MainRouter by lazy {
        MainRouterImpl(mainNavigator)
    }

    private val tabsFragmentInjector by lazy {
        TabsFragmentInjector(mainNavigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spritz_activity)
        supportFragmentManager.registerFragmentLifecycleCallbacks(tabsFragmentInjector, false)
        mainRouter.openTabsScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(tabsFragmentInjector)
    }
}