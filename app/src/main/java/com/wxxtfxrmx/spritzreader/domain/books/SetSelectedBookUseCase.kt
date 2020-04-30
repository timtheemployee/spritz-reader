package com.wxxtfxrmx.spritzreader.domain.books

class SetSelectedBookUseCase(
    private val selectedBookRepository: SelectedBookRepository
) {

    operator fun invoke(book: Book) {
        selectedBookRepository.set(book)
    }
}