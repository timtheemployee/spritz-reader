package com.wxxtfxrmx.spritzreader.domain.description

import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.Description

interface DescriptionRepository {

    fun get(book: Book): Description
}