package com.wxxtfxrmx.spritzreader.presentation.spritz

import com.wxxtfxrmx.spritzreader.presentation.core.View

interface SpritzView : View {

	fun showResumedState(millis: Long)

	fun showPausedState()

	fun initialRenderWord(word: String)

	fun renderWord(word: String, millis: Long)

	fun showDisabledState()

	fun exit()
}