package com.wxxtfxrmx.spritzreader.presentation.spritz

import android.util.Log
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.entity.Config
import com.wxxtfxrmx.spritzreader.domain.entity.Page
import com.wxxtfxrmx.spritzreader.domain.usecase.*
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class SpritzPresenter @Inject constructor(
    private val getSelectedBookUseCase: GetSelectedBookUseCase,
    private val setSelectedBookUseCase: SetSelectedBookUseCase,
    private val getPageUseCase: GetPageUseCase,
    private val getBookSizeUseCase: GetBookSizeUseCase,
    private val getConfigUseCase: GetConfigUseCase
) : Presenter<SpritzView>() {

    private lateinit var book: Book
    private lateinit var lastPage: Page
    private lateinit var config: Config

    private var wordsOnPage: List<String> = emptyList()
    private var wordIndexOnPage = 0
    private var pageSize = 0

    private var isRunning = false

    override fun onFirstViewAttach() {
        getSelectedBookUseCase()?.let {
            book = it
            wordIndexOnPage = book.wordOnPage

            lastPage = getPageUseCase(book)
            pageSize = lastPage.lastIndex()
            wordsOnPage = lastPage.toList()

            config = getConfigUseCase()

            view?.initialRenderWord(wordsOnPage.word())
        } ?: onBackPressed()
    }

    fun onActionButtonClicked() {
        isRunning = !isRunning

        if (isRunning) {
            view?.showResumedState(config.toMillis())
        } else {
            view?.showPausedState()
        }
    }

    fun onBackPressed() {
        val size = getBookSizeUseCase(book)
        val progress: Float = book.lastPage / size.toFloat() * 100
        book = book.copy(wordOnPage = wordIndexOnPage, progress = progress)
        setSelectedBookUseCase(book)
        view?.exit()
    }

    fun onRenderComplete() {
        if (!isRunning) return

        if (wordIndexOnPage == pageSize) {
            val bookLastPage = book.lastPage
            book = book.copy(lastPage = bookLastPage + 1)
            lastPage = getPageUseCase(book)
            pageSize = lastPage.lastIndex()
            wordsOnPage = lastPage.toList()
            wordIndexOnPage = 0
            book = book.copy(wordOnPage = wordIndexOnPage)
        } else {
            wordIndexOnPage++
        }

        renderWord(wordsOnPage.word(), config.toMillis())
    }

    private fun renderWord(word: String, time: Long) {
        view?.renderWord(word, time)
    }

    private fun List<String>.word(): String =
        this[wordIndexOnPage]

    private fun Config.toMillis(): Long =
        60000L / wordInMin

    fun onResume() {
        onRenderComplete()
    }
}