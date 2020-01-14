package com.wxxtfxrmx.spritzreader.navigation.spritz

import com.wxxtfxrmx.spritzreader.navigation.Command
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator

interface GlobalRouter {
    fun openTabScreen()
}

class GlobalRouterImpl(private val navigator: Navigator): GlobalRouter {

    override fun openTabScreen() {
        navigator.execute(Command.Open(Destination.TabsScreen))
    }
}