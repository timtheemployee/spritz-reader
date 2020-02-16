package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.data.description.DescriptionRepositoryImpl
import com.wxxtfxrmx.spritzreader.data.library.BooksRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.FragmentScope
import com.wxxtfxrmx.spritzreader.domain.description.DescriptionRepository
import com.wxxtfxrmx.spritzreader.domain.library.BooksRepository
import dagger.Binds
import dagger.Module

@Module
interface LibraryFragmentModule {

    @Binds
    @FragmentScope
    fun bindBooksRepository(repository: BooksRepositoryImpl): BooksRepository

    @Binds
    @FragmentScope
    fun bindDescriptionRepository(repository: DescriptionRepositoryImpl): DescriptionRepository
}