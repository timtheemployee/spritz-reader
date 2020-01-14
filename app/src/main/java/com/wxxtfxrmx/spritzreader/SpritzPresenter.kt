package com.wxxtfxrmx.spritzreader

import com.wxxtfxrmx.spritzreader.navigation.spritz.GlobalRouter
import com.wxxtfxrmx.spritzreader.ui.core.Presenter

class SpritzPresenter(private val globalRouter: GlobalRouter): Presenter<SpritzMvpView>() {

    override fun onFirstViewAttach() {
        globalRouter.openTabScreen()
    }
}