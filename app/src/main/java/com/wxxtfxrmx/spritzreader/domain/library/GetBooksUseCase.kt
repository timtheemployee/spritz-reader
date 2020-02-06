package com.wxxtfxrmx.spritzreader.domain.library

import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(): List<Book> =
        booksRepository.get()
}