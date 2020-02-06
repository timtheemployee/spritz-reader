package com.wxxtfxrmx.spritzreader.domain.tabs

interface TabsRepository {

    fun get(): Tab

    fun set(tab: Tab)
}