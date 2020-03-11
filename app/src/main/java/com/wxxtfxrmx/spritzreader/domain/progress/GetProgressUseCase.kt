package com.wxxtfxrmx.spritzreader.domain.progress

import com.wxxtfxrmx.spritzreader.domain.books.Book
import javax.inject.Inject

class GetProgressUseCase @Inject constructor(
    private val repository: ProgressRepository
) {

    operator fun invoke(book: Book): Progress =
        repository.get(book) ?: Progress(book)
}