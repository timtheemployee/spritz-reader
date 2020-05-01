package com.wxxtfxrmx.spritzreader.domain.books

interface SelectedBookDataSource {

    fun get(): Book?

    fun set(book: Book)
}