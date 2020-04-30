package com.wxxtfxrmx.spritzreader.domain.description

import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.Description
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetDescriptionUseCase (
    private val repository: DescriptionRepository
) {

    suspend operator fun invoke(book: Book): Description =
        withContext(Dispatchers.IO) {
            repository.get(book)
        }
}