package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.books.*
import com.wxxtfxrmx.spritzreader.domain.description.GetDescriptionUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouter
import com.wxxtfxrmx.spritzreader.navigation.tabs.TabsNavigator
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import kotlinx.coroutines.*
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val createCoverUseCase: CreateCoverUseCase,
    private val getDescriptionUseCase: GetDescriptionUseCase,
    private val setSelectedBookUseCase: SetSelectedBookUseCase
) : Presenter<LibraryView>() {

    private var items: List<LibraryItem> = emptyList()

    override fun onFirstViewAttach() {

        view?.requestWritePermission()
    }

    private fun loadBooks() {
        view?.showProgress()
        launch(Dispatchers.Main) {

            items = getBooksUseCase().map {
                fillItem(it)
            }

            view?.hideProgress()
            if (items.isNotEmpty()) {
                view?.showLibraryItems(items)
            } else {
                view?.showBooksNotFound()
            }
        }
    }

    private suspend fun fillItem(book: Book): LibraryItem =
        withContext(Dispatchers.IO) {
            LibraryItem(book, getDescriptionUseCase(book), createCoverUseCase(book))
        }


    fun onBookClicked(book: Book) {
        setSelectedBookUseCase(book)
    }

    fun onWritePermissionGranted(granted: Boolean = true) {
        if (granted) {
            loadBooks()
        }
    }
}