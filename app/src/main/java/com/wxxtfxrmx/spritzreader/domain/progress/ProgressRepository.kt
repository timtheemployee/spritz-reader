package com.wxxtfxrmx.spritzreader.domain.progress

import com.wxxtfxrmx.spritzreader.domain.books.Book

interface ProgressRepository {

    fun get(book: Book): Progress?

    fun set(progress: Progress)
}