package com.wxxtfxrmx.spritzreader.di.ui

import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.data.tabs.TabsRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.FragmentScope
import com.wxxtfxrmx.spritzreader.domain.tabs.TabsRepository
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouter
import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouterImpl
import com.wxxtfxrmx.spritzreader.navigation.tabs.TabsNavigator
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface TabsFragmentModule {

    @Module
    companion object {

        @FragmentScope
        @Provides
        fun provideTabsFragmentManager(fragment: TabsFragment): FragmentManager =
            fragment.childFragmentManager

        @FragmentScope
        @Provides
        fun provideResId(): Int = R.id.tabsContainer

    }


    @Binds
    @FragmentScope
    fun bindTabsRepository(repository: TabsRepositoryImpl): TabsRepository

    @FragmentScope
    @Binds
    fun bindTabsNavigator(tabsNavigator: TabsNavigator): Navigator

    @FragmentScope
    @Binds
    fun bindTabsRouter(router: TabRouterImpl): TabRouter
}