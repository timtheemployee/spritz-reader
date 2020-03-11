package com.wxxtfxrmx.spritzreader.di.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.data.covers.CoversDataSource
import com.wxxtfxrmx.spritzreader.data.covers.CoversDataSourceImpl
import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesDataSource
import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesDataSourceImpl
import com.wxxtfxrmx.spritzreader.data.files.FilesDataSource
import com.wxxtfxrmx.spritzreader.data.files.FilesDataSourceImpl
import com.wxxtfxrmx.spritzreader.di.resources.ResourcesModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        ResourcesModule::class,
        SelectedBookModule::class,
        ProgressModule::class
    ]
)
class DataModule {

    @Provides
    @Singleton
    fun providePreferenceDataSource(
        sharedPreferences: SharedPreferences,
        gson: Gson
    ): PreferencesDataSource =
        PreferencesDataSourceImpl(
            sharedPreferences,
            gson
        )

    @Provides
    @Singleton
    fun provideFilesDataSource(paths: List<String?>): FilesDataSource =
        FilesDataSourceImpl(paths)

    @Provides
    @Singleton
    fun provideCoversDataSource(internalStorage: String?): CoversDataSource =
        CoversDataSourceImpl(internalStorage)
}