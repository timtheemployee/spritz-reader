package com.wxxtfxrmx.spritzreader.data.books

import com.wxxtfxrmx.spritzreader.data.files.FilesDataSource
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val filesDataSource: FilesDataSource
) : BooksRepository {

    override fun get(): List<Book> {
        val files = filesDataSource.get()

        return files.map { file -> Book(file.absolutePath, file.name) }
    }

}