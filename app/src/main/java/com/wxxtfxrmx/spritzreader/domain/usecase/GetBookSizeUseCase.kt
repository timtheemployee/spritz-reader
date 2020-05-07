package com.wxxtfxrmx.spritzreader.domain.usecase

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import java.io.File
import javax.inject.Inject

class GetBookSizeUseCase @Inject constructor() {

    operator fun invoke(book: Book): Int {
        val file = File(book.path)

        require(file.exists()) { "File should be exists" }

        val reader = PdfReader(file)
        val document = PdfDocument(reader)

        return document.numberOfPages
    }
}