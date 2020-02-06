package com.wxxtfxrmx.spritzreader.data

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

interface PreferencesDataSource {

    fun <T> get(key: String, clazz: Class<T>): T?

    fun set(key: String, any: Any)
}

class PreferencesDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
): PreferencesDataSource {

    override fun <T> get(key: String, clazz: Class<T>): T? =
        sharedPreferences.getString(key, null)
            ?.let { gson.fromJson(it, clazz) }

    override fun set(key: String, any: Any) {
        sharedPreferences.edit().apply {
            putString(key, gson.toJson(any))
            apply()
        }
    }
}