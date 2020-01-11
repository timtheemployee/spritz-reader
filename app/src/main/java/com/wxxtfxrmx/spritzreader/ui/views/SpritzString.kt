package com.wxxtfxrmx.spritzreader.ui.views

class SpritzString(private val text: String) {

    private companion object {
        const val EVEN_DIVIDER = 2
    }

    private val focusPosition: Int = if (text.length % EVEN_DIVIDER == 0) {
        (text.length / EVEN_DIVIDER) - 1
    } else {
        (text.length) / 2
    }

    fun focus(): String =
        text[focusPosition].toString()

    fun start(): String =
        text.substring(0, focusPosition)

    fun end(): String =
        text.substring(focusPosition + 1, text.length)
}