package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.domain.entity.Config
import javax.inject.Inject

class SettingsInteractor @Inject constructor(

) {

    fun getConfig(): Config {
        return Config(10)
    }

    fun setConfig(config: Config) {

    }
}