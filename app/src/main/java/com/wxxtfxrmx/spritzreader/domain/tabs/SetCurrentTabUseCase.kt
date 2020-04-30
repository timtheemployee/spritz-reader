package com.wxxtfxrmx.spritzreader.domain.tabs

class SetCurrentTabUseCase(
    private val tabsRepository: TabsRepository
) {

    operator fun invoke(tab: Tab) {
        tabsRepository.set(tab)
    }
}