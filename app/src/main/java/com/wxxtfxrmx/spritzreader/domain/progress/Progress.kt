package com.wxxtfxrmx.spritzreader.domain.progress

import com.wxxtfxrmx.spritzreader.domain.books.Book

data class Progress(
    val book: Book,
    val pagePosition: Int = 0,
    val wordPosition: Int = 0
)