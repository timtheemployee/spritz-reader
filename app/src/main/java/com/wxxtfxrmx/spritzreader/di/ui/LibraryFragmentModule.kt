package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.data.description.DescriptionRepositoryImpl
import com.wxxtfxrmx.spritzreader.data.books.BooksRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.FragmentScope
import com.wxxtfxrmx.spritzreader.di.data.SelectedBookModule
import com.wxxtfxrmx.spritzreader.domain.description.DescriptionRepository
import com.wxxtfxrmx.spritzreader.domain.books.BooksRepository
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