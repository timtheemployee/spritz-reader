package com.wxxtfxrmx.spritzreader.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.domain.tabs.Tab

interface TabsDataSource {

    fun get(): Tab

    fun set(tab: Tab)
}

class TabsDataSourceImpl(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
): TabsDataSource{

    private companion object {
        const val TAB_KEY = "TAB_KEY"
        const val LIBRARY = "LIBRARY"
    }

    override fun get(): Tab =
        sharedPreferences
            .getString(TAB_KEY, LIBRARY)
            .let { gson.fromJson(it, Tab::class.java) }

    override fun set(tab: Tab) {
        sharedPreferences.edit()
            .putString(TAB_KEY, gson.toJson(tab))
            .apply()
    }
}