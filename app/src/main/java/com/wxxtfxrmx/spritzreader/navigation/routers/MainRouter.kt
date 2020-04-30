package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator

class MainRouter constructor(
    private val navigator: Navigator
){

    fun openTabsScreen() {
        navigator.execute(Open(Destination.TabsScreen))
    }
}