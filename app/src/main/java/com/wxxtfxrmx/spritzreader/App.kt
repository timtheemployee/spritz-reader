package com.wxxtfxrmx.spritzreader

import android.app.Application
import com.wxxtfxrmx.spritzreader.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

	@Inject
	lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

	override fun androidInjector(): AndroidInjector<Any> =
		dispatchingAndroidInjector

	override fun onCreate() {
		super.onCreate()

		DaggerAppComponent
			.builder()
			.context(this)
			.build()
			.inject(this)
	}
}