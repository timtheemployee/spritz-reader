package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Destination.*
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import javax.inject.Inject

interface TabRouter {

    fun openLibraryScreen()

    fun openReadingScreen()
}

class TabRouterImpl @Inject constructor(
    private val navigator: Navigator
): TabRouter {

    override fun openLibraryScreen() {
        navigator.execute(Open(LibraryScreen))
    }

    override fun openReadingScreen() {
        navigator.execute(Open(ReadingScreen))
    }
}