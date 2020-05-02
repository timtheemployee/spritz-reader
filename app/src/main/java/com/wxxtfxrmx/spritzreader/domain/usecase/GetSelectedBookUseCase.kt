package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.data.datasource.SelectedBookDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import javax.inject.Inject

class GetSelectedBookUseCase @Inject constructor(
    private val selectedBookDataSource: SelectedBookDataSource
) {

    operator fun invoke(): Book? =
        selectedBookDataSource.get()
}