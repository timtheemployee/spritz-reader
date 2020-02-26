package com.wxxtfxrmx.spritzreader.domain.description

import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.books.Description

interface DescriptionRepository {

    fun get(book: Book): Description
}