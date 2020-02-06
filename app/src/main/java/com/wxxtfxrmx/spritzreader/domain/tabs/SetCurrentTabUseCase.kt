package com.wxxtfxrmx.spritzreader.domain.tabs

import javax.inject.Inject

class SetCurrentTabUseCase @Inject constructor(
    private val tabsRepository: TabsRepository
) {

    operator fun invoke(tab: Tab) {
        tabsRepository.set(tab)
    }
}