package com.wxxtfxrmx.spritzreader.data.files

import java.io.File

interface FilesDataSource {

    fun get(): List<File>

}

class FilesDataSourceImpl(
    private val paths: List<String?>
): FilesDataSource {

    private companion object {
        const val PDF = ".pdf"
    }

    override fun get(): List<File> {

        val files = paths
            .filterNotNull()
            .map { File("$it/") }

        return files.flatMap(::findFiles)
    }

    private fun findFiles(file: File): List<File> =
        file.walk()
            .filter { it.absolutePath.endsWith(PDF) }
            .toList()
}