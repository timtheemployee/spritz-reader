package com.wxxtfxrmx.spritzreader.presentation.tabs

import com.wxxtfxrmx.spritzreader.domain.tabs.GetCurrentTabUseCase
import com.wxxtfxrmx.spritzreader.domain.tabs.SetCurrentTabUseCase
import com.wxxtfxrmx.spritzreader.domain.tabs.Tab
import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouter
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class TabsPresenter @Inject constructor(
    private val router: TabRouter,
    private val getCurrentTabUseCase: GetCurrentTabUseCase,
    private val setCurrentTabUseCase: SetCurrentTabUseCase
): Presenter<TabsView>() {


    override fun onFirstViewAttach() {
        openLastTab()
    }

    private fun openLastTab() {

//        when(getCurrentTabUseCase()) {
//            Tab.LIBRARY -> router.openLibraryScreen()
//            Tab.READING -> router.openReadingScreen()
//        }

        router.openLibraryScreen()
    }

    fun onLibraryClicked() {
        setCurrentTabUseCase(Tab.LIBRARY)
        router.openLibraryScreen()
    }

    fun onReadingClicked() {
        setCurrentTabUseCase(Tab.READING)
        router.openReadingScreen()
    }
}