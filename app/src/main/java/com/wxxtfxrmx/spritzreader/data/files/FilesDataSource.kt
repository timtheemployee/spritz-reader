package com.wxxtfxrmx.spritzreader.data.files

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

        return files.flatMap(::findFiles)
    }

    private fun findFiles(file: File): List<File> =
        file.walk()
            .filter { it.absolutePath.endsWith(".pdf") }
            .toList()
}