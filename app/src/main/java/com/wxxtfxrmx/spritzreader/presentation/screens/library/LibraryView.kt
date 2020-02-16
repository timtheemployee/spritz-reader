package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.presentation.core.View

interface LibraryView: View {

    fun showLibraryItems(books: List<LibraryItem>)

    fun showBooksNotFound()

    fun showProgress()

    fun hideProgress()

    fun requestWritePermission()
}