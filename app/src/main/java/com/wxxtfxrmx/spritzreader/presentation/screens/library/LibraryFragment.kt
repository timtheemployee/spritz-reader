package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import kotlinx.android.synthetic.main.library_fragment.*
import javax.inject.Inject

class LibraryFragment: BaseFragment(), LibraryView {

    companion object {
        fun newInstance(): Fragment =
            LibraryFragment()
    }

    override val layout = R.layout.library_fragment

    @Inject
    lateinit var presenter: LibraryPresenter

    private lateinit var adapter: LibraryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LibraryAdapter(presenter::onBookClicked)
        booksList.adapter = adapter

        presenter.attachView(this)
    }

    override fun showBooksList(books: List<Book>) {
        booksList.isVisible = true
        noBooksLayout.isVisible = false

        adapter.items = books
    }

    override fun showBooksNotFound() {
        booksList.isVisible = false
        noBooksLayout.isVisible = true
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}