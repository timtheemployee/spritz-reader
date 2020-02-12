package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.library.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import kotlinx.coroutines.*
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val createCoverUseCase: CreateCoverUseCase
) : Presenter<LibraryView>() {

    private var books: List<Book> = emptyList()

    override fun onFirstViewAttach() {

        view?.requestWritePermission()
    }

    private fun loadBooks() {
        view?.showProgress()
        launch {
            books = getBooksUseCase()

            //createCoversIfNeed(books)


            view?.hideProgress()
            if (books.isEmpty()) {
                view?.showBooksNotFound()
            } else {
                view?.showBooksList(books)
            }

        }
    }

    private suspend fun createCoversIfNeed(books: List<Book>) {
        books.forEach {
            if (it.coverPath == null) {
                createCoverUseCase(it.path)
            }
        }
    }

    fun onBookClicked(book: Book) {

    }

    fun onWritePermissionGranted(granted: Boolean = true) {
        if (granted) {
            loadBooks()
        }
    }
}