package com.wxxtfxrmx.spritzreader.di.ui

import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.SpritzActivity
import com.wxxtfxrmx.spritzreader.di.*
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouter
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouterImpl
import com.wxxtfxrmx.spritzreader.navigation.tabs.MainNavigator
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface SpritzActivityModule {

    @Module
    companion object {

        @Provides
        @ActivityScope
        @ParentFragmentManager
        fun provideMainFragmentManager(activity: SpritzActivity): FragmentManager =
            activity.supportFragmentManager

        @Provides
        @ActivityScope
        @ParentContainerId
        fun provideContainerId(): Int =
            R.id.content

    }

    @Binds
    @ActivityScope
    @ParentNavigator
    fun bindMainNavigator(navigator: MainNavigator): Navigator

    @Binds
    @ActivityScope
    fun bindMainRouter(router: MainRouterImpl): MainRouter


    @FragmentScope
    @ContributesAndroidInjector(modules = [TabsFragmentModule::class])
    fun provideTabsFragment(): TabsFragment
}