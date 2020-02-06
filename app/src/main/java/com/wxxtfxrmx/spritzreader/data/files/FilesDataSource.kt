package com.wxxtfxrmx.spritzreader.data.files

import android.os.Environment
import java.io.File

interface FilesDataSource {

    fun getFiles(): List<File>
}

class FilesDataSourceImpl(
    private val rootPath: String
): FilesDataSource {

    override fun getFiles(): List<File> = emptyList()
}