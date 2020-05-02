package com.wxxtfxrmx.spritzreader.data.repository

import com.wxxtfxrmx.spritzreader.data.datasource.BooksLocalDataSource
import com.wxxtfxrmx.spritzreader.data.datasource.FilesDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.repository.BooksRepository
import java.io.File
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val filesDataSource: FilesDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun get(): List<Book> {
        val files = filesDataSource.get()
        val existingBooks = booksLocalDataSource.get()

        return files.map { it.toBook(existingBooks) }
    }

    private fun File.toBook(existingBooks: List<Book>) =
        existingBooks.firstOrNull { it.path == absolutePath } ?: Book(
            absolutePath,
            name
        )

    override fun existing(book: Book): Boolean =
        booksLocalDataSource.exists(book)

    override fun update(book: Book) {
        booksLocalDataSource.update(book)
    }
}