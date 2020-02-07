package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import javax.inject.Inject

class LibraryFragment: BaseFragment() {

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
    }
}