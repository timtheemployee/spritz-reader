package com.wxxtfxrmx.spritzreader.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NestedFragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope