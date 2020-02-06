package com.wxxtfxrmx.spritzreader.domain.tabs

import javax.inject.Inject

class GetCurrentTabUseCase @Inject constructor(
    private val repository: TabsRepository
) {

    operator fun invoke(): Tab =
        repository.get()
}