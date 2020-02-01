package com.wxxtfxrmx.spritzreader.di

import com.wxxtfxrmx.spritzreader.SpritzActivity
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [SpritzActivityModule::class])
    abstract fun provideSpritzActivity(): SpritzActivity


}