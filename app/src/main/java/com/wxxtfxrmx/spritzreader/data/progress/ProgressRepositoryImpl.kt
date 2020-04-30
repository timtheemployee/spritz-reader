package com.wxxtfxrmx.spritzreader.data.progress

import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesDataSource
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.progress.Progress
import com.wxxtfxrmx.spritzreader.domain.progress.ProgressRepository

//TODO Add SQL Datasource for progress & settings
class ProgressRepositoryImpl(
    private val preferencesDataSource: PreferencesDataSource,
    private val gson: Gson
): ProgressRepository {

    override fun get(book: Book): Progress? =
        preferencesDataSource.get(book.path, Progress::class.java)

    override fun set(progress: Progress) {
        gson.toJson(progress).let {
            preferencesDataSource.set(progress.book.path, it)
        }
    }
}