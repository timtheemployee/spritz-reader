package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.di.*
import com.wxxtfxrmx.spritzreader.di.navigation.NavigationModule
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NavigationModule::class])
interface SpritzActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [TabsModule::class])
    fun provideTabsFragment(): TabsFragment
}