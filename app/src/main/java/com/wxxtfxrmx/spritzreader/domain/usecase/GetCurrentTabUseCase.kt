package com.wxxtfxrmx.spritzreader.domain.usecase

import com.wxxtfxrmx.spritzreader.data.datasource.TabsDataSource
import com.wxxtfxrmx.spritzreader.domain.entity.Tab
import javax.inject.Inject

class GetCurrentTabUseCase @Inject constructor(
    private val dataSource: TabsDataSource
) {

    operator fun invoke(): Tab =
        dataSource.get()
}