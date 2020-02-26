package com.wxxtfxrmx.spritzreader.domain.books

import javax.inject.Inject

class GetSelectedBookUseCase @Inject constructor(
    private val selectedBookRepository: SelectedBookRepository
) {

    operator fun invoke(): Book? =
        selectedBookRepository.get()
}