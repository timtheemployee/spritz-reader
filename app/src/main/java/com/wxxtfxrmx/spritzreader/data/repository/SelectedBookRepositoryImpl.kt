package com.wxxtfxrmx.spritzreader.data.repository

import com.wxxtfxrmx.spritzreader.data.datasource.BooksLocalDataSource
import com.wxxtfxrmx.spritzreader.data.datasource.SelectedBookDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.repository.SelectedBookRepository
import javax.inject.Inject

class SelectedBookRepositoryImpl @Inject constructor(
    private val selectedBookDataSource: SelectedBookDataSource,
    private val bookDataSource: BooksLocalDataSource
): SelectedBookRepository {

    override fun set(book: Book) {
        selectedBookDataSource.set(book)
        bookDataSource.update(book)
    }

    override fun get(): Book? =
        selectedBookDataSource.get()
}