package com.wxxtfxrmx.spritzreader

import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.entity.Cover
import com.wxxtfxrmx.spritzreader.domain.repository.BooksRepository
import com.wxxtfxrmx.spritzreader.domain.usecase.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.LibraryRouter
import com.wxxtfxrmx.spritzreader.presentation.screens.library.LibraryPresenter
import com.wxxtfxrmx.spritzreader.presentation.screens.library.LibraryView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class LibraryPresenterTest {

    private val view = mock(LibraryView::class.java)
    private val getBooksUseCase = mock(GetBooksUseCase::class.java)
    private val createCoverUseCase = mock(CreateCoverUseCase::class.java)
    private val setSelectedBooksUseCase = mock(SetSelectedBookUseCase::class.java)
    private val router = mock(LibraryRouter::class.java)

    private val presenter: LibraryPresenter = LibraryPresenter(
        getBooksUseCase,
        createCoverUseCase,
        setSelectedBooksUseCase,
        router
    )

    @Test
    fun `view attached EXPECT start loading books`() = runBlockingTest {
        val book = mock(Book::class.java)
        val cover = mock(Cover::class.java)

        `when`(getBooksUseCase.invoke()).thenReturn(listOf(book))
        `when`(createCoverUseCase(book)).thenReturn(cover)

        presenter.attachView(view)
        presenter.onWritePermissionGranted(true)

        verify(view).requestWritePermission()
        verify(getBooksUseCase).invoke()
        verify(createCoverUseCase).invoke(book)
        verify(view).showProgress()
        verify(view).hideProgress()
        verify(view).showBooks(listOf(book))
    }
}
