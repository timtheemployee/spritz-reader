package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.presentation.core.View

interface LibraryView: View {

    fun showBooks(books: List<Book>)

    fun showBooksNotFound()

    fun showProgress()

    fun hideProgress()

    fun requestWritePermission()
}