package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.tabs.MainNavigator

interface MainRouter {
    fun openTabsScreen()
}

class MainRouterImpl(
    private val mainNavigator: MainNavigator
): MainRouter {

    override fun openTabsScreen() {
        mainNavigator.execute(Open(Destination.TabsScreen))
    }
}