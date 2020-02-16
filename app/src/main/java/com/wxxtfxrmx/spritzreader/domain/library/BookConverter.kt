package com.wxxtfxrmx.spritzreader.domain.library

import java.io.File
import javax.inject.Inject

class BookConverter @Inject constructor() {

    fun convert(file: File): Book {
        require(file.absolutePath.endsWith(".pdf")) {
            "Illegal file format"
        }

        return Book(file.absolutePath, file.name.substringBeforeLast("."))
    }
}