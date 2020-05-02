package com.wxxtfxrmx.spritzreader.domain.repository

import com.wxxtfxrmx.spritzreader.domain.entity.Book

interface SelectedBookRepository {

    fun set(book: Book)

    fun get(): Book?
}