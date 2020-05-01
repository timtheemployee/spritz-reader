package com.wxxtfxrmx.spritzreader.data.books

import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.SelectedBookDataSource
import javax.inject.Inject

class SelectedBookDataSource @Inject constructor(
    private val preferences: Preferences
): SelectedBookDataSource {

    private companion object {
        const val SELECTED_BOOK_KEY = "selected_book_key"
    }

    override fun get(): Book? =
        preferences.get(SELECTED_BOOK_KEY, Book::class.java)

    override fun set(book: Book) {
        preferences.set(SELECTED_BOOK_KEY, book)
    }
}