package com.wxxtfxrmx.spritzreader.data.library

import com.wxxtfxrmx.spritzreader.data.files.FilesDataSource
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val filesDataSource: FilesDataSource,
    private val bookConverter: BookConverter
): BooksRepository {

    override fun get(): List<Book> =
        filesDataSource.get()
            .map(bookConverter::convert)
}