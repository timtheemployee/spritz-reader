package com.wxxtfxrmx.spritzreader.data.files

import java.io.File
import javax.inject.Inject

interface FilesDataSource {

    fun get(): List<File>
}

class FilesDataSourceImpl @Inject constructor(
    private val rootPath: String
): FilesDataSource {

    override fun get(): List<File> {
        val file = File(rootPath)

        return file.walk()
            .onEnter { it.endsWith(".pdf") }
            .toList()
    }
}