package com.wxxtfxrmx.spritzreader.domain.tabs

class GetCurrentTabUseCase(
    private val repository: TabsRepository
) {

    operator fun invoke(): Tab =
        repository.get()
}