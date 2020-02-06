package com.wxxtfxrmx.spritzreader.domain.library

interface BooksRepository {

    fun get(): List<Book>
}