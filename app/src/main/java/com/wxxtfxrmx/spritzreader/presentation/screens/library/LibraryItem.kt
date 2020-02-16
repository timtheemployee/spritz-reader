package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.library.Description
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.Cover

data class LibraryItem(
    val book: Book,
    val description: Description,
    val cover: Cover?
)