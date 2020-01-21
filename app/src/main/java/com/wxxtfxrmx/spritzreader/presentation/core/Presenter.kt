package com.wxxtfxrmx.spritzreader.presentation.core

import java.lang.ref.WeakReference

abstract class Presenter<V: View> {

    private var viewRef: WeakReference<V>? = null

    protected val view: V?
        get() = viewRef?.get()

    fun attachView(view: V) {
        viewRef = WeakReference(view)
        onFirstViewAttach()
    }

    fun detachView() {
        viewRef = null
    }

    abstract fun onFirstViewAttach()
}