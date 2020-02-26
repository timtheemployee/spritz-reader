package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.books.Description
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.Cover

data class LibraryItem(
    val book: Book,
    val description: Description,
    val cover: Cover?
)