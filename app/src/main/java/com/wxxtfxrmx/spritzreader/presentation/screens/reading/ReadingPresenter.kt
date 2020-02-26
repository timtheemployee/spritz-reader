package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import com.wxxtfxrmx.spritzreader.domain.books.GetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class ReadingPresenter @Inject constructor(
    private val getSelectedBookUseCase: GetSelectedBookUseCase
): Presenter<ReadingView>() {

    override fun onFirstViewAttach() {

        view?.showBook(getSelectedBookUseCase()?.name)
    }
}