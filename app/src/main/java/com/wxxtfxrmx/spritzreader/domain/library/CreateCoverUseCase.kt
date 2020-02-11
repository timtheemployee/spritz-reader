package com.wxxtfxrmx.spritzreader.domain.library

import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class CreateCoverUseCase @Inject constructor(
    private val covers: CoverHelper
) {

    // TODO make it async with Deferred & coroutines
    suspend operator fun invoke(path: String) {
        withContext(Dispatchers.IO) {
            val bookFile = File(path)
            val descriptor =
                ParcelFileDescriptor.open(bookFile, ParcelFileDescriptor.MODE_READ_ONLY)
            val renderer = PdfRenderer(descriptor)

            if (renderer.pageCount > 0) {
                val page = renderer.openPage(0)

                val cover = covers.createCover()

                page.render(cover, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)

                covers.saveCover(cover, path)

                page.close()
                renderer.close()
            }
        }
    }
}