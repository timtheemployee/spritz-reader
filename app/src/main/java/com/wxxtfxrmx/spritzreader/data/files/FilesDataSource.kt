package com.wxxtfxrmx.spritzreader.data.files

import android.util.Log
import java.io.File
import javax.inject.Inject

interface FilesDataSource {

    fun get(): List<File>
}

class FilesDataSourceImpl @Inject constructor(
    private val paths: List<String?>
): FilesDataSource {

    override fun get(): List<File> {

        val files = paths
            .filterNotNull()
            .map { File("$it/") }

        files.forEach {
            Log.e("TAG", "Files -> ${it.listFiles()?.size}")
        }

        return files
    }

    private fun findFiles(file: File): List<File> =
        file.walk()
            .toList()
}