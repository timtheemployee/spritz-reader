package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.data.description.DescriptionRepositoryImpl
import com.wxxtfxrmx.spritzreader.data.books.BooksRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.NestedFragmentScope
import com.wxxtfxrmx.spritzreader.domain.description.DescriptionRepository
import com.wxxtfxrmx.spritzreader.domain.books.BooksRepository
import dagger.Binds
import dagger.Module

@Module
interface LibraryFragmentModule {

    @Binds
    @NestedFragmentScope
    fun bindBooksRepository(repository: BooksRepositoryImpl): BooksRepository

    @Binds
    @NestedFragmentScope
    fun bindDescriptionRepository(repository: DescriptionRepositoryImpl): DescriptionRepository
}