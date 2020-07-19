package com.wxxtfxrmx.spritzreader.di.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wxxtfxrmx.spritzreader.domain.usecase.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.LibraryRouter
import com.wxxtfxrmx.spritzreader.presentation.screens.library.LibraryViewModel
import javax.inject.Inject

class LibraryViewModelFactory @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val createCoverUseCase: CreateCoverUseCase,
    private val setSelectedBookUseCase: SetSelectedBookUseCase,
    private val libraryRouter: LibraryRouter
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(LibraryViewModel::class.java))

        return LibraryViewModel(
            getBooksUseCase,
            createCoverUseCase,
            setSelectedBookUseCase,
            libraryRouter
        ) as T
    }
}