package com.wxxtfxrmx.spritzreader.presentation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import java.lang.ref.WeakReference

abstract class Presenter<V: View>: CoroutineScope by MainScope() {

    private var viewRef: WeakReference<V>? = null

    protected val view: V?
        get() = viewRef?.get()

    fun attachView(view: V) {
        viewRef = WeakReference(view)
        onFirstViewAttach()
    }

    fun detachView() {
        viewRef = null
        cancel()
    }

    abstract fun onFirstViewAttach()
}