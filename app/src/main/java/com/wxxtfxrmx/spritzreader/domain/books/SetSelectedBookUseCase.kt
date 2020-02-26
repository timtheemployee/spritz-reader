package com.wxxtfxrmx.spritzreader.domain.books

import javax.inject.Inject

class SetSelectedBookUseCase @Inject constructor(
    private val selectedBookRepository: SelectedBookRepository
) {

    operator fun invoke(book: Book) {
        selectedBookRepository.set(book)
    }
}