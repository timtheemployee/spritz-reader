package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.di.data.SelectedBookModule
import dagger.Module

@Module(includes = [SelectedBookModule::class])
interface ReadingFragmentModule {
}