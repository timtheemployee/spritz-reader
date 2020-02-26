package com.wxxtfxrmx.spritzreader.domain.books

interface SelectedBookRepository {

    fun get(): Book?

    fun set(book: Book)
}