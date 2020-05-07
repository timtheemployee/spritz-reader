package com.wxxtfxrmx.spritzreader.domain.usecase

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor
import com.wxxtfxrmx.spritzreader.SpritzTextExtractionStrategy
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.entity.Page
import java.io.File
import javax.inject.Inject

class GetPageUseCase @Inject constructor() {

	operator fun invoke(book: Book): Page {
		val file = File(book.path)

		require(file.exists()) { "File should be exists" }

		val reader = PdfReader(file)
		val document = PdfDocument(reader)

		val extractStrategy = SpritzTextExtractionStrategy()
		val page = document.getPage(book.lastPage + 1)
		val extractedText = PdfTextExtractor.getTextFromPage(page, extractStrategy).replace("-", "")

		return Page(extractedText)
	}
}