package com.wxxtfxrmx.spritzreader.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject

//TODO Add SQL support for progress storage
interface ProgressDataSource {

    fun get(book: String): String?

    fun set(book: String, progress: String)
}

class ProgressDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
): ProgressDataSource {

    override fun get(book: String): String? {
        TODO("Not yet implemented")
    }

    override fun set(book: String, progress: String) {
        TODO("Not yet implemented")
    }
}