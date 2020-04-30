package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Destination.*
import com.wxxtfxrmx.spritzreader.navigation.Navigator

class TabRouter(
    private val navigator: Navigator
) {

    fun openLibraryScreen() {
        navigator.execute(Open(LibraryScreen))
    }

    fun openReadingScreen() {
        navigator.execute(Open(ReadingScreen))
    }
}