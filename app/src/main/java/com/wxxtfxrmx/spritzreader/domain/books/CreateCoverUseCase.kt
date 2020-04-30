package com.wxxtfxrmx.spritzreader.domain.books

import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class CreateCoverUseCase(
    private val covers: CoverHelper
) {

    suspend operator fun invoke(book: Book): Cover? =
        withContext(Dispatchers.IO) {
            val bookFile = File(book.path)
            val descriptor =
                ParcelFileDescriptor.open(bookFile, ParcelFileDescriptor.MODE_READ_ONLY)
            val renderer = PdfRenderer(descriptor)

            return@withContext if (renderer.pageCount > 0) {
                val page = renderer.openPage(0)

                val cover = covers.createCover()

                page.render(cover, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)

                val coverPath = covers.saveCover(cover, book.name)

                page.close()
                renderer.close()

                coverPath?.let { Cover(it).apply { Log.e("TAG", "Path -> $path") } }
            } else {
                null
            }
        }

}