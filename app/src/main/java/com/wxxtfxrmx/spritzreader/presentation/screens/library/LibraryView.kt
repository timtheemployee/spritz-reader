package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.presentation.core.View

interface LibraryView: View {

    fun showBooksList(books: List<Book>)
}