package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.domain.entity.Config
import com.wxxtfxrmx.spritzreader.domain.repository.ConfigRepository
import javax.inject.Inject

class GetConfigUseCase @Inject constructor(
	private val configRepository: ConfigRepository
) {

	operator fun invoke(): Config =
		configRepository.get()
}
