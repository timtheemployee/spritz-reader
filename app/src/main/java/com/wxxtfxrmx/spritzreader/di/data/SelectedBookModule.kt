package com.wxxtfxrmx.spritzreader.di.data

import com.wxxtfxrmx.spritzreader.data.books.SelectedBookRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.FragmentScope
import com.wxxtfxrmx.spritzreader.domain.books.SelectedBookRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface SelectedBookModule {

    @Binds
    @Singleton
    fun bindSelectedBookRepository(repository: SelectedBookRepositoryImpl): SelectedBookRepository
}