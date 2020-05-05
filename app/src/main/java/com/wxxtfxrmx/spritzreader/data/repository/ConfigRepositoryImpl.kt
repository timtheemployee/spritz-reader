package com.wxxtfxrmx.spritzreader.data.repository

import com.wxxtfxrmx.spritzreader.data.datasource.ConfigDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Config
import com.wxxtfxrmx.spritzreader.domain.repository.ConfigRepository
import javax.inject.Inject

class ConfigRepositoryImpl @Inject constructor(
	private val configDataSource: ConfigDataSource
) : ConfigRepository {

	override fun get(): Config =
		configDataSource.get()

	override fun set(config: Config) {
		configDataSource.set(config)
	}
}