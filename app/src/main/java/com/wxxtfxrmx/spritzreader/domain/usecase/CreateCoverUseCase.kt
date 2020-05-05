package com.wxxtfxrmx.spritzreader.domain.usecase

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.entity.Cover
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class CreateCoverUseCase @Inject constructor(
	private val destination: String?
) {

	private companion object {
		const val WIDTH = 200
		const val HEIGHT = 300
	}

	suspend operator fun invoke(book: Book): Cover? =
		withContext(Dispatchers.IO) {
			val bookFile = File(book.path)
			val descriptor =
				ParcelFileDescriptor.open(bookFile, ParcelFileDescriptor.MODE_READ_ONLY)
			val renderer = PdfRenderer(descriptor)

			val page = renderer.openPage(0)

			val cover = createCover()

			page.render(cover, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)

			val coverPath = saveCover(cover, book.name)

			page.close()
			renderer.close()

			coverPath?.let(::Cover)
		}

	private fun createCover(): Bitmap {
		val config = Bitmap.Config.ARGB_8888

		return Bitmap.createBitmap(
			WIDTH,
			HEIGHT, config)
	}

	private fun saveCover(cover: Bitmap, path: String): String? {
		val coverPath = path.createName()
		val result = File(destination, coverPath)

		val outputStream = ByteArrayOutputStream()
		cover.compress(Bitmap.CompressFormat.PNG, 0, outputStream)

		val bytes = outputStream.toByteArray()

		val fileOutputStream = FileOutputStream(result)

		fileOutputStream.write(bytes)
		fileOutputStream.flush()
		fileOutputStream.close()

		return result.absolutePath
	}

	private fun String.createName() = "$this.png"
}