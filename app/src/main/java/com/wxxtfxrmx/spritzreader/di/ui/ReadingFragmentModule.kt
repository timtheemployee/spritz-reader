package com.wxxtfxrmx.spritzreader.di.ui

import com.wxxtfxrmx.spritzreader.di.SettingsFragmentScope
import com.wxxtfxrmx.spritzreader.presentation.screens.settings.SettingsBottomSheetFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ReadingFragmentModule {

	@SettingsFragmentScope
	@ContributesAndroidInjector
	fun provideSettingsBottomSheetFragment(): SettingsBottomSheetFragment
}