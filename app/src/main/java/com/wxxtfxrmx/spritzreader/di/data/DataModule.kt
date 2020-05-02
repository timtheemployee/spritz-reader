package com.wxxtfxrmx.spritzreader.di.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.wxxtfxrmx.spritzreader.data.datasource.*
import com.wxxtfxrmx.spritzreader.data.db.BooksSqliteStorage
import com.wxxtfxrmx.spritzreader.data.preferences.Preferences
import com.wxxtfxrmx.spritzreader.data.preferences.PreferencesImpl
import com.wxxtfxrmx.spritzreader.data.repository.SelectedBookRepositoryImpl
import com.wxxtfxrmx.spritzreader.di.resources.ResourcesModule
import com.wxxtfxrmx.spritzreader.domain.repository.SelectedBookRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ResourcesModule::class])
interface DataModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun providePreferenceDataSource(
            sharedPreferences: SharedPreferences,
            gson: Gson
        ): Preferences =
            PreferencesImpl(sharedPreferences, gson)

        @JvmStatic
        @Provides
        @Singleton
        fun provideFilesDataSource(paths: List<String?>): FilesDataSource =
            FilesDataSourceImpl(paths)

        @JvmStatic
        @Provides
        @Singleton
        fun provideCoversDataSource(internalStorage: String?): CoversDataSource =
            CoversDataSourceImpl(internalStorage)

        @JvmStatic
        @Provides
        @Singleton
        fun provideBooksLocalDataSource(storage: BooksSqliteStorage): BooksLocalDataSource =
            BooksLocalDataSourceImpl(storage)

        @JvmStatic
        @Provides
        @Singleton
        fun provideSelectedBookDataSource(preferences: Preferences): SelectedBookDataSource =
            SelectedBookDataSourceImpl(preferences)
    }


    @Binds
    @Singleton
    fun bindSelectedBookRepository(impl: SelectedBookRepositoryImpl): SelectedBookRepository
}