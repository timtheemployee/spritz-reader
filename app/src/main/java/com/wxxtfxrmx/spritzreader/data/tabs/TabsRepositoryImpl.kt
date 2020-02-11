package com.wxxtfxrmx.spritzreader.data.tabs

import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesDataSource
import com.wxxtfxrmx.spritzreader.domain.tabs.Tab
import com.wxxtfxrmx.spritzreader.domain.tabs.TabsRepository
import javax.inject.Inject

class TabsRepositoryImpl @Inject constructor(
    private val preferencesDataSource: PreferencesDataSource
): TabsRepository {

    private companion object {

        const val TAB_KEY = "TAB_KEY"
    }

    override fun get(): Tab =
        preferencesDataSource.get(TAB_KEY, Tab::class.java) ?: Tab.BOOKMARKS

    override fun set(tab: Tab) {
        preferencesDataSource.set(TAB_KEY, tab)
    }
}