package com.wxxtfxrmx.spritzreader

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.di.DaggerAppComponent
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlin.reflect.KClass

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

		val autoFragmentInjector = AutoInjectFragmentCallbacks()
		val autoActivityInjector = AutoInjectActivityCallbacks(autoFragmentInjector)

		registerActivityLifecycleCallbacks(autoActivityInjector)
	}
}

class AutoInjectActivityCallbacks(
	private val fragmentLifecycleCallbacks: FragmentManager.FragmentLifecycleCallbacks
): Application.ActivityLifecycleCallbacks {

	override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
		if (activity is HasAndroidInjector)
			AndroidInjection.inject(activity)

		if (activity is FragmentActivity)
			activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true)
	}

	override fun onActivityDestroyed(activity: Activity) {
		if (activity is FragmentActivity)
			activity.supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks)
	}

	override fun onActivityPaused(activity: Activity) {}
	override fun onActivityStarted(activity: Activity) {}
	override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
	override fun onActivityStopped(activity: Activity) {}
	override fun onActivityResumed(activity: Activity) {}
}

class AutoInjectFragmentCallbacks(): FragmentManager.FragmentLifecycleCallbacks() {
	override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
		super.onFragmentCreated(fm, f, savedInstanceState)

		if (!f.javaClass.isAssignableFrom(BaseFragment::class.java) && (f::class.java.hasInjectFields() || f is HasAndroidInjector)) {
			AndroidSupportInjection.inject(f)
		}
	}

	private fun Class<out Fragment>.hasInjectFields(): Boolean =
		declaredFields.any { it.isAnnotationPresent(Inject::class.java) }
}