package com.wxxtfxrmx.spritzreader.domain.books

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {

    suspend operator fun invoke(): List<Book> =
        withContext(Dispatchers.IO) {
            booksRepository.get()
        }

}