package com.wxxtfxrmx.spritzreader.data.books

import com.wxxtfxrmx.spritzreader.data.files.FilesDataSource
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.BookConverter
import com.wxxtfxrmx.spritzreader.domain.books.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val filesDataSource: FilesDataSource,
    private val converter: BookConverter
) : BooksRepository {

    override fun get(): List<Book> {
        val files = filesDataSource.get()

        return files.map(converter::convert)
    }

}