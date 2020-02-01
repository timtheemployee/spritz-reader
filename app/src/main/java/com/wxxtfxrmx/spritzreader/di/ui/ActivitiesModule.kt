package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.SpritzActivity
import com.wxxtfxrmx.spritzreader.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [SpritzActivityModule::class])
    abstract fun provideSpritzActivity(): SpritzActivity


}