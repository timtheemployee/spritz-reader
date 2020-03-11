package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import com.wxxtfxrmx.spritzreader.domain.books.GetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.domain.page.GetPageUseCase
import com.wxxtfxrmx.spritzreader.domain.progress.GetProgressUseCase
import com.wxxtfxrmx.spritzreader.domain.progress.Progress
import com.wxxtfxrmx.spritzreader.domain.progress.SetProgressUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class ReadingPresenter @Inject constructor(
    getSelectedBookUseCase: GetSelectedBookUseCase,
    private val getPageUseCase: GetPageUseCase,
    private val getProgressUseCase: GetProgressUseCase,
    private val setProgressUseCase: SetProgressUseCase
): Presenter<ReadingView>() {

    private val selectedBook = getSelectedBookUseCase()
    private lateinit var progress: Progress

    override fun onFirstViewAttach() {
        selectedBook?.let { book ->
            progress = getProgressUseCase(book)
            val pageContent = getPageUseCase(progress)
            view?.renderPage(pageContent)
        }
    }

    fun onProgressChanged() {
        setProgressUseCase(progress)
    }
}