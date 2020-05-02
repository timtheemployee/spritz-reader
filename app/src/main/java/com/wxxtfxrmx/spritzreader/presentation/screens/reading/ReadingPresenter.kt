package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import com.wxxtfxrmx.spritzreader.domain.usecase.GetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetPageUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class ReadingPresenter @Inject constructor(
    getSelectedBookUseCase: GetSelectedBookUseCase,
    private val getPageUseCase: GetPageUseCase
) : Presenter<ReadingView>() {

    private val selectedBook = getSelectedBookUseCase()

    override fun onFirstViewAttach() {
        selectedBook?.let { book ->
            val lastPage = getPageUseCase(book)
            view?.renderPage(lastPage)
        }
    }

    fun onProgressChanged() {

    }
}