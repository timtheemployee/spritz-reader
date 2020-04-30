package com.wxxtfxrmx.spritzreader.domain.books

import java.io.File

class BookConverter {

    fun convert(file: File): Book {
        require(file.absolutePath.endsWith(".pdf")) {
            "Illegal file format"
        }

        return Book(file.absolutePath, file.name.substringBeforeLast("."))
    }
}