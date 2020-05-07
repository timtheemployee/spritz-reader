package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import com.wxxtfxrmx.spritzreader.domain.usecase.GetPageUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.ReadingRouter
import com.wxxtfxrmx.spritzreader.presentation.core.Presenter
import javax.inject.Inject

class ReadingPresenter @Inject constructor(
	private val getSelectedBookUseCase: GetSelectedBookUseCase,
	private val getPageUseCase: GetPageUseCase,
	private val router: ReadingRouter
) : Presenter<ReadingView>() {

	override fun onFirstViewAttach() {
		getSelectedBookUseCase()?.let { book ->
			val lastPage = getPageUseCase(book)
			view?.renderPage(lastPage.content)
		}
	}

	fun onStartReadingClick() {
		router.openSpritzScreen()
	}
}