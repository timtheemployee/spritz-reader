package com.wxxtfxrmx.spritzreader.data.progress

import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.books.Book
import com.wxxtfxrmx.spritzreader.domain.progress.Progress
import com.wxxtfxrmx.spritzreader.domain.progress.ProgressRepository
import javax.inject.Inject

//TODO Add SQL Datasource for progress & settings
class ProgressRepositoryImpl @Inject constructor(
    private val preferences: Preferences,
    private val gson: Gson
): ProgressRepository {

    override fun get(book: Book): Progress? =
        preferences.get(book.path, Progress::class.java)

    override fun set(progress: Progress) {
        gson.toJson(progress).let {
            preferences.set(progress.book.path, it)
        }
    }
}