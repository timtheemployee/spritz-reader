package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.data.datasource.TabsDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Tab
import javax.inject.Inject

class SetCurrentTabUseCase @Inject constructor(
    private val tabsDataSource: TabsDataSource
) {

    operator fun invoke(tab: Tab) {
        tabsDataSource.set(tab)
    }
}