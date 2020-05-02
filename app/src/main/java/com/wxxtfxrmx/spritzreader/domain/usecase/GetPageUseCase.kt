package com.wxxtfxrmx.spritzreader.domain.usecase

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import java.io.File
import javax.inject.Inject

class GetPageUseCase @Inject constructor() {

    operator fun invoke(book: Book): String {
        val file = File(book.path)

        require(file.exists()) { "File should be exists" }

        val reader = PdfReader(file)
        val document = PdfDocument(reader)

        val extractStrategy = SimpleTextExtractionStrategy()
        val page = document.getPage(book.lastPage)
        return PdfTextExtractor.getTextFromPage(page, extractStrategy)
    }
}