package com.wxxtfxrmx.spritzreader.di.data

import com.wxxtfxrmx.spritzreader.data.progress.ProgressRepositoryImpl
import com.wxxtfxrmx.spritzreader.domain.progress.ProgressRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ProgressModule {

    @Binds
    @Singleton
    fun bindProgressRepository(repository: ProgressRepositoryImpl): ProgressRepository
}