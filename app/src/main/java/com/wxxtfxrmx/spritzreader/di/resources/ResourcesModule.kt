package com.wxxtfxrmx.spritzreader.di.resources

import android.content.Context
import android.content.SharedPreferences
import android.os.Environment
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wxxtfxrmx.spritzreader.BuildConfig
import com.wxxtfxrmx.spritzreader.data.db.BooksSqliteStorage
import com.wxxtfxrmx.spritzreader.di.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ResourcesModule {

    @Provides
    @Singleton
    fun provideRootPath(): List<String?> =
        listOf(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath,
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
        )

    @Provides
    @Singleton
    fun provideInternalStoragePath(@AppScope context: Context): String? =
        context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)?.absolutePath


    @Provides
    @Singleton
    fun provideSharedPreferences(@AppScope context: Context): SharedPreferences =
        context.getSharedPreferences(BuildConfig.SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    fun provideBooksDatabaseStorage(context: Context): BooksSqliteStorage =
        BooksSqliteStorage(context)
}