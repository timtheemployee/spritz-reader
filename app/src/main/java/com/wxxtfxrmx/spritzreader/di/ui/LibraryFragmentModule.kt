package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.data.repository.BooksRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.NestedFragmentScope
import com.wxxtfxrmx.spritzreader.domain.repository.BooksRepository
import dagger.Binds
import dagger.Module

@Module
interface LibraryFragmentModule {

	@Binds
	@NestedFragmentScope
	fun bindBooksRepository(repository: BooksRepositoryImpl): BooksRepository

}