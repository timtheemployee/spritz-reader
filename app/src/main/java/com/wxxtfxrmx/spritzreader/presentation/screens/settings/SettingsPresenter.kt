package com.wxxtfxrmx.spritzreader.presentation.screens.settings

import android.graphics.Bitmap
import com.wxxtfxrmx.spritzreader.domain.entity.Config
import com.wxxtfxrmx.spritzreader.domain.usecase.GetConfigUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetConfigUseCase
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class SettingsPresenter @Inject constructor(
	private val getConfigUseCase: GetConfigUseCase,
	private val setConfigUseCase: SetConfigUseCase
): Presenter<SettingsView>() {

	override fun onFirstViewAttach() {
		val config = getConfigUseCase()

		view?.showWordsInMinute(config.wordInMin)
	}

	fun onCancel(progress: Int) {
		val config = Config(progress)
		setConfigUseCase(config)
	}
}