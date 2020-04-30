package com.wxxtfxrmx.spritzreader.domain.books

class GetSelectedBookUseCase(
    private val selectedBookRepository: SelectedBookRepository
) {

    operator fun invoke(): Book? =
        selectedBookRepository.get()
}