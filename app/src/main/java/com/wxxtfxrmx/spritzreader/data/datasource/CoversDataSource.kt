package com.wxxtfxrmx.spritzreader.data.datasource

import java.io.File

interface CoversDataSource {

    fun get(): List<String>?

}

class CoversDataSourceImpl(
    internalStoragePath: String?
): CoversDataSource {

    private val storage: File? = if (internalStoragePath == null) {
        null
    } else {
        File(internalStoragePath)
    }

    override fun get(): List<String>? =
        storage?.listFiles()
            ?.map { it.absolutePath }

}