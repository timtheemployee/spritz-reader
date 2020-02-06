package com.wxxtfxrmx.spritzreader.di.resources

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wxxtfxrmx.spritzreader.di.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ResourcesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@AppScope context: Context): SharedPreferences =
        context.getSharedPreferences("SPRITZ_READER", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().create()
}