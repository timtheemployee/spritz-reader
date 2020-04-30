package com.wxxtfxrmx.spritzreader.domain.page

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy
import com.wxxtfxrmx.spritzreader.domain.progress.Progress
import java.io.File

class GetPageUseCase {

    operator fun invoke(progress: Progress): String {
        val file = File(progress.book.path)

        require(file.exists()) { "File should be exists" }

        val reader = PdfReader(file)
        val document = PdfDocument(reader)

        val extractStrategy = SimpleTextExtractionStrategy()
        val page = document.getPage(progress.pagePosition + 1)
        return PdfTextExtractor.getTextFromPage(page, extractStrategy)
    }
}