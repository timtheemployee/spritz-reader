package com.wxxtfxrmx.spritzreader.data.tabs

import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.tabs.Tab
import com.wxxtfxrmx.spritzreader.domain.tabs.TabsRepository
import javax.inject.Inject

class TabsRepositoryImpl @Inject constructor(
    private val preferences: Preferences
): TabsRepository {

    private companion object {

        const val TAB_KEY = "TAB_KEY"
    }

    override fun get(): Tab =
        preferences.get(TAB_KEY, Tab::class.java) ?: Tab.LIBRARY

    override fun set(tab: Tab) {
        preferences.set(TAB_KEY, tab)
    }
}