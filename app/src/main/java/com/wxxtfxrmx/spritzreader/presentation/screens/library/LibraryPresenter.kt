package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.util.Log
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
): Presenter<LibraryView>() {

    private var books: List<Book> = emptyList()

    override fun onFirstViewAttach() {

        books = getBooksUseCase()
        view?.showBooksList(books)
    }

    fun onBookClicked(book: Book) {
        Log.e("Books", "Tag")
    }
}