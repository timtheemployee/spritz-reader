package com.wxxtfxrmx.spritzreader.domain.books

interface BooksRepository {

    fun get(): List<Book>
}