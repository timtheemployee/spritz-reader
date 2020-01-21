package com.wxxtfxrmx.spritzreader.presentation.tabs

import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouter
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter

class TabsPresenter(
    private val router: TabRouter
): Presenter<TabsView>() {


    override fun onFirstViewAttach() {

    }

    fun onLibraryClicked() {
        router.openLibraryScreen()
    }

    fun onRecentClicked() {
        router.openRecentScreen()
    }

    fun onBookmarksClicked() {
        router.openBookmarksScreen()
    }
}