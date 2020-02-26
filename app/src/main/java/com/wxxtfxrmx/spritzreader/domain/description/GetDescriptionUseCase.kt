package com.wxxtfxrmx.spritzreader.domain.description

import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.Description
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDescriptionUseCase @Inject constructor(
    private val repository: DescriptionRepository
) {

    suspend operator fun invoke(book: Book): Description =
        withContext(Dispatchers.IO) {
            repository.get(book)
        }
}