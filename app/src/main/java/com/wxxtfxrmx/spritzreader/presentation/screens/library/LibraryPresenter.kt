package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
): Presenter<LibraryView>() {

    private var books: List<Book> = emptyList()

    override fun onFirstViewAttach() {

        view?.requestWritePermission()
        loadBooks()
    }

    private fun loadBooks() {
        view?.showProgress()
        books = getBooksUseCase()

        view?.hideProgress()
        if (books.isEmpty()) {
            view?.showBooksNotFound()
        } else {
            view?.showBooksList(books)
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