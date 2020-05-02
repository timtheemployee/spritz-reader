package com.wxxtfxrmx.spritzreader.data.datasource

import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.entity.Tab
import javax.inject.Inject

interface TabsDataSource {

    fun get(): Tab

    fun set(tab: Tab)
}

class TabsDataSourceImpl @Inject constructor(
    private val preferences: Preferences
): TabsDataSource {

    private companion object {

        const val TAB_KEY = "TAB_KEY"
    }

    override fun get(): Tab =
        preferences.get(TAB_KEY, Tab::class.java) ?: Tab.LIBRARY

    override fun set(tab: Tab) {
        preferences.set(TAB_KEY, tab)
    }
}