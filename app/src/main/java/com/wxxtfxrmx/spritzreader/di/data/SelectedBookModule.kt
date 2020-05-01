package com.wxxtfxrmx.spritzreader.di.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface SelectedBookModule {

    @Binds
    @Singleton
    fun bindSelectedBookRepository(repository: SelectedBookDataSource): com.wxxtfxrmx.spritzreader.domain.books.SelectedBookDataSource
}