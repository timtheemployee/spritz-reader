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
        const val WIDTH = 50
        const val HEIGHT = 100
    }

    //TODO make it async with coroutines
    fun createCover(): Bitmap {
        val config = Bitmap.Config.ARGB_8888

        return Bitmap.createBitmap(WIDTH, HEIGHT, config)
    }


    // TODO throw error when file is not created, make it async with coroutines
    // TODO make result callbacks with Deferred
    fun saveCover(cover: Bitmap, path: String) {
        val result = File(destination, createName(path))
        Log.d(TAG, "Cover file -> ${result.absolutePath}")
        val isCreated = result.createNewFile()
        Log.d(TAG, "Is cover created?-> $isCreated")
        if (!isCreated) return

        val outputStream = ByteArrayOutputStream()
        cover.compress(Bitmap.CompressFormat.PNG, 0, outputStream)

        val bytes = outputStream.toByteArray()

        val fileOutputStream = FileOutputStream(result)

        fileOutputStream.write(bytes)
        fileOutputStream.flush()
        fileOutputStream.close()
    }

    private fun createName(path: String): String =
        path
            .substringAfterLast("/")
            .substringBeforeLast(".")
            .let { "$it.png" }

}