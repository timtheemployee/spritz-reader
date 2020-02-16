package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.description.GetDescriptionUseCase
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.library.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import kotlinx.coroutines.*
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val createCoverUseCase: CreateCoverUseCase,
    private val getDescriptionUseCase: GetDescriptionUseCase
) : Presenter<LibraryView>() {

    private var items: List<LibraryItem> = emptyList()

    override fun onFirstViewAttach() {

        view?.requestWritePermission()
    }

    private fun loadBooks() {
        view?.showProgress()
        launch(Dispatchers.Main) {

            items = getBooksUseCase().map {
                fillItem(it)
            }

            view?.hideProgress()
            if (items.isNotEmpty()) {
                view?.showLibraryItems(items)
            } else {
                view?.showBooksNotFound()
            }
        }
    }

    private suspend fun fillItem(book: Book): LibraryItem =
        withContext(Dispatchers.IO) {
            LibraryItem(book, getDescriptionUseCase(book), createCoverUseCase(book))
        }


    fun onBookClicked(book: Book) {

    }

    fun onWritePermissionGranted(granted: Boolean = true) {
        if (granted) {
            loadBooks()
        }
    }
}