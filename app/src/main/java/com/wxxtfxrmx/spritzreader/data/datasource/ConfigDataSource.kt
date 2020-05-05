package com.wxxtfxrmx.spritzreader.data.datasource

import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.domain.entity.Config
import javax.inject.Inject

interface ConfigDataSource {

	fun get(): Config

	fun set(config: Config)
}

class ConfigDataSourceImpl @Inject constructor(
	private val preferences: Preferences
) : ConfigDataSource {

	private companion object {
		const val WORDS_IN_MINUTE_KEY = "words_in_minute_key"
	}

	override fun get(): Config =
		preferences.get(WORDS_IN_MINUTE_KEY, Config::class.java)
			?: Config(wordInMin = 100)

	override fun set(config: Config) {
		preferences.set(WORDS_IN_MINUTE_KEY, config)
	}
}