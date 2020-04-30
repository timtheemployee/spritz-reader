package com.wxxtfxrmx.spritzreader.domain.books

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetBooksUseCase(
    private val booksRepository: BooksRepository
) {

    suspend operator fun invoke(): List<Book> =
        withContext(Dispatchers.IO) {
            booksRepository.get()
        }
}