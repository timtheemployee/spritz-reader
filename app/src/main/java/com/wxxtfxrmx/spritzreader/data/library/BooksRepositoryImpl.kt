package com.wxxtfxrmx.spritzreader.data.library

import com.wxxtfxrmx.spritzreader.data.covers.CoversDataSource
import com.wxxtfxrmx.spritzreader.data.files.FilesDataSource
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.BooksRepository
import java.io.File
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val filesDataSource: FilesDataSource,
    private val coversRepository: CoversDataSource
) : BooksRepository {

    override fun get(): List<Book> {
        val files = filesDataSource.get()
        val covers = coversRepository.get()

        return files.map { createBook(it, covers) }
    }

    private fun createBook(file: File, covers: List<String>?): Book =
        Book(file.absolutePath, file.name, /*covers?.firstOrNull { it == getName(file.absolutePath) }*/ null)

    private fun getName(bookPath: String): String =
        bookPath
            .substringAfterLast("/")
            .substringBeforeLast(".")
            .let { "$it.png" }
}