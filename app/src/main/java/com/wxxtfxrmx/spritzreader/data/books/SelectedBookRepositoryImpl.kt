package com.wxxtfxrmx.spritzreader.data.books

import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesDataSource
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.SelectedBookRepository

class SelectedBookRepositoryImpl(
    private val preferencesDataSource: PreferencesDataSource
): SelectedBookRepository {

    private companion object {
        const val SELECTED_BOOK_KEY = "selected_book_key"
    }

    override fun get(): Book? =
        preferencesDataSource.get(SELECTED_BOOK_KEY, Book::class.java)

    override fun set(book: Book) {
        preferencesDataSource.set(SELECTED_BOOK_KEY, book)
    }
}