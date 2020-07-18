package com.wxxtfxrmx.spritzreader.presentation.screens.settings

import com.wxxtfxrmx.spritzreader.domain.entity.Config
import com.wxxtfxrmx.spritzreader.domain.usecase.GetConfigUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetConfigUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SettingsInteractor
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class SettingsPresenter @Inject constructor(
	private val settingsInteractor: SettingsInteractor
) : Presenter<SettingsView>() {

	override fun onFirstViewAttach() {
		val config = settingsInteractor.getConfig()

		view?.showWordsInMinute(config.wordInMin)
	}

	fun onCancel(progress: Int) {
		val config = Config(progress)
		settingsInteractor.setConfig(config)
	}
}
