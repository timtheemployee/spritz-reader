package com.wxxtfxrmx.spritzreader.domain.books

import javax.inject.Inject

class SetSelectedBookUseCase @Inject constructor(
    private val selectedBookDataSource: SelectedBookDataSource
) {

    operator fun invoke(book: Book) {
        selectedBookDataSource.set(book)
    }
}