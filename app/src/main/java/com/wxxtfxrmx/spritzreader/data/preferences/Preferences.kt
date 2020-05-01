package com.wxxtfxrmx.spritzreader.data.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject

interface Preferences {

    fun <T> get(key: String, clazz: Class<T>): T?

    fun set(key: String, any: Any)
}

class PreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
): Preferences {

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