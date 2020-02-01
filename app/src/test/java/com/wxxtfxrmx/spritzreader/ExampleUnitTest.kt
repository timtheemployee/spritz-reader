package com.wxxtfxrmx.spritzreader

import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.domain.tabs.Tab
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `test gson serialization`() {
        val gson = Gson()

        val tab = Tab.BOOKMARKS

        val result = gson.toJson(tab)
        println(result)

        assertTrue(true)
    }

    @Test
    fun `test gson desiralization`() {
        val gson = Gson()

        val tabString = "BOOKMARKS"

        val result = gson.fromJson(tabString, Tab::class.java)

        assertTrue(result == Tab.BOOKMARKS)
    }
}
