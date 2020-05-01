package com.wxxtfxrmx.spritzreader.domain.books

import javax.inject.Inject

class GetSelectedBookUseCase @Inject constructor(
    private val selectedBookDataSource: SelectedBookDataSource
) {

    operator fun invoke(): Book? =
        selectedBookDataSource.get()
}