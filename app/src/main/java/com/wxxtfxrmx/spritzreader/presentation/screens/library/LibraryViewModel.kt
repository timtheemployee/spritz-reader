package com.wxxtfxrmx.spritzreader.presentation.screens.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.domain.usecase.CreateCoverUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.GetBooksUseCase
import com.wxxtfxrmx.spritzreader.domain.usecase.SetSelectedBookUseCase
import com.wxxtfxrmx.spritzreader.navigation.routers.LibraryRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibraryViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val createCoverUseCase: CreateCoverUseCase,
    private val setSelectedBookUseCase: SetSelectedBookUseCase,
    private val router: LibraryRouter
) : ViewModel() {

    private val permissionAskedData = MutableLiveData<Boolean>()
    val permissionAsked: LiveData<Boolean>
        get() = permissionAskedData

    private val booksData = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>>
        get() = booksData

    private val progressData = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = progressData

    private val noBooksStubData = MutableLiveData<Boolean>()
    val booksStub: LiveData<Boolean>
        get() = noBooksStubData

    init {
        permissionAskedData.value = true
    }

    fun openBook(book: Book) {
        setSelectedBookUseCase(book)
        router.openReadingScreen()
    }

    fun loadBooks() {
        progressData.value = true
        viewModelScope.launch(Dispatchers.Main) {
            val books = getBooksUseCase().map {
                if (it.cover.isNullOrEmpty()) {
                    it.copy(cover = createCoverUseCase(book = it)?.path)
                } else {
                    it
                }
            }

            booksData.value = books
            progressData.value = false
        }
    }

    fun showNoBooksStub() {
        noBooksStubData.value = true
    }
}