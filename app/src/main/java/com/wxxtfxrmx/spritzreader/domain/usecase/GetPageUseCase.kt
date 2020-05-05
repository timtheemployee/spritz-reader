package com.wxxtfxrmx.spritzreader.domain.usecase

import android.util.Log
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor
import com.wxxtfxrmx.spritzreader.SpritzTextExtractionStrategy
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import java.io.File
import javax.inject.Inject

class GetPageUseCase @Inject constructor() {

	private companion object {
		val NEW_PARAGRAPH_REGEX = "\\.\\s{3,}".toRegex()
	}

	operator fun invoke(book: Book): String {
		val file = File(book.path)

		require(file.exists()) { "File should be exists" }

		val reader = PdfReader(file)
		val document = PdfDocument(reader)

		val extractStrategy = SpritzTextExtractionStrategy()
		val page = document.getPage(book.lastPage + 1)
		return PdfTextExtractor.getTextFromPage(page, extractStrategy).replace("-", "").apply {
			Log.e("SOME TAG", this)
		}
	}
}