package com.wxxtfxrmx.spritzreader.domain.library

import android.graphics.Bitmap
import android.util.Log
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class CoverHelper @Inject constructor(
    private val destination: String?
) {

    private companion object {
        const val TAG = "CoverHelper"
        const val WIDTH = 200
        const val HEIGHT = 400
    }

    fun createCover(): Bitmap {
        val config = Bitmap.Config.ARGB_8888

        return Bitmap.createBitmap(WIDTH, HEIGHT, config)
    }


    fun saveCover(cover: Bitmap, path: String): String? {
        val coverPath = createName(path)
        val result = File(destination, coverPath)
//        val isCreated = result.createNewFile()
//        if (!isCreated) return null

        val outputStream = ByteArrayOutputStream()
        cover.compress(Bitmap.CompressFormat.PNG, 0, outputStream)

        val bytes = outputStream.toByteArray()

        val fileOutputStream = FileOutputStream(result)

        fileOutputStream.write(bytes)
        fileOutputStream.flush()
        fileOutputStream.close()

        return result.absolutePath
    }

    private fun createName(path: String): String = "$path.png"
}