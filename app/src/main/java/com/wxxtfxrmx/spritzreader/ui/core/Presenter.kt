package com.wxxtfxrmx.spritzreader.ui.core

import java.lang.ref.WeakReference

abstract class Presenter<V: View> {

    private var viewRef: WeakReference<V>? = null

    protected val view: V?
        get() = viewRef?.get()

    protected open fun attachView(view: V) {
        viewRef = WeakReference(view)
        onFirstViewAttach()
    }

    protected open fun onDestroyView() {
        viewRef = null
    }

    abstract fun onFirstViewAttach()
}