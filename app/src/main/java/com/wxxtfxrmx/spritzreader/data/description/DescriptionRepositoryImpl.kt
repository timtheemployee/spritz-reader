package com.wxxtfxrmx.spritzreader.data.description

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy
import com.wxxtfxrmx.spritzreader.domain.description.DescriptionRepository
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.Description
import java.io.File
import java.lang.Exception
import javax.inject.Inject

class DescriptionRepositoryImpl @Inject constructor(): DescriptionRepository {

    override fun get(book: Book): Description {
        val file = File(book.path)

        require(file.exists()) { "Book with ${book.path} does not exists" }

        try {
            val reader = PdfDocument(PdfReader(file))

            if (reader.numberOfPages > 0) {
                val firstPage = reader.firstPage

                val extractionStrategy = SimpleTextExtractionStrategy()
                return Description(PdfTextExtractor.getTextFromPage(firstPage, extractionStrategy))
            }
        } catch (e: Exception) {
            return Description("Не удалось получить информацию")
        }

        return Description("")
    }
}