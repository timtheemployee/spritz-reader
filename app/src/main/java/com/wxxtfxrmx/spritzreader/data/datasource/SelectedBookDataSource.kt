package com.wxxtfxrmx.spritzreader.data.datasource

import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import javax.inject.Inject

interface SelectedBookDataSource {

    fun get(): Book?

    fun set(book: Book)
}

class SelectedBookDataSourceImpl @Inject constructor(
    private val preferences: Preferences
) : SelectedBookDataSource {

    private companion object {
        const val SELECTED_BOOK_KEY = "selected_book_key"
    }

    override fun get(): Book? =
        preferences.get(SELECTED_BOOK_KEY, Book::class.java)

    override fun set(book: Book) {
        preferences.set(SELECTED_BOOK_KEY, book)
    }
}