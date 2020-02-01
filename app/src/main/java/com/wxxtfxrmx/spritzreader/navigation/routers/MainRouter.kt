package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.di.ParentNavigator
import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import javax.inject.Inject

interface MainRouter {
    fun openTabsScreen()
}

class MainRouterImpl @Inject constructor(
    @ParentNavigator private val mainNavigator: Navigator
): MainRouter {

    override fun openTabsScreen() {
        mainNavigator.execute(Open(Destination.TabsScreen))
    }
}