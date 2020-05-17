package com.wxxtfxrmx.spritzreader.presentation.screens.library

import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.usecase.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.LibraryRouter
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LibraryPresenter @Inject constructor(
	private val getBooksUseCase: GetBooksUseCase,
	private val createCoverUseCase: CreateCoverUseCase,
	private val setSelectedBookUseCase: SetSelectedBookUseCase,
	private val router: LibraryRouter
) : Presenter<LibraryView>(), CoroutineScope {


	private var items: List<Book> = emptyList()

	override fun onFirstViewAttach() {

		view?.requestWritePermission()
	}

	private fun loadBooks() {
		view?.showProgress()

		launch(Dispatchers.Main) {
			items = getBooksUseCase().map { book ->
				createCoverIfNotExists(book)
			}

			view?.hideProgress()
			if (items.isNotEmpty()) {
				view?.showBooks(items)
			} else {
				view?.showBooksNotFound()
			}
		}
	}

	private suspend fun createCoverIfNotExists(book: Book): Book =
		if (book.cover.isNullOrEmpty()) {
			val cover = createCoverUseCase(book)
			book.copy(cover = cover?.path)
		} else {
			book
		}

	fun onBookClicked(book: Book) {
		setSelectedBookUseCase(book)
			.also { router.openReadingScreen() }
	}

	fun onWritePermissionGranted(granted: Boolean = true) {
		if (granted) {
			loadBooks()
		}
	}
}