package com.wxxtfxrmx.spritzreader.data.library

import com.wxxtfxrmx.spritzreader.domain.library.Book
import java.io.File
import javax.inject.Inject

class BookConverter @Inject constructor() {

    fun convert(file: File): Book {

        require(file.endsWith(".pdf")) { "Illegal file type" }

        return Book(file.absolutePath, file.name)
    }
}