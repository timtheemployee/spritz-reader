package com.wxxtfxrmx.spritzreader.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ParentNavigator

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ParentFragmentManager

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ParentContainerId