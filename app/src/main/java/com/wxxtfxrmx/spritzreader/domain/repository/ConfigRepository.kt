package com.wxxtfxrmx.spritzreader.domain.repository

import com.wxxtfxrmx.spritzreader.domain.entity.Config

interface ConfigRepository {

	fun get(): Config

	fun set(config: Config)
}