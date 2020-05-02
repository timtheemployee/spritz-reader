package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.repository.SelectedBookRepository
import javax.inject.Inject

class SetSelectedBookUseCase @Inject constructor(
    private val selectedBookRepository: SelectedBookRepository
) {

    operator fun invoke(book: Book) {
        selectedBookRepository.set(book)
    }
}