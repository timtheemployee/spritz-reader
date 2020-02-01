package com.wxxtfxrmx.spritzreader.di

import android.content.Context
import com.wxxtfxrmx.spritzreader.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        DataModule::class,
        ActivitiesModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@AppScope context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}