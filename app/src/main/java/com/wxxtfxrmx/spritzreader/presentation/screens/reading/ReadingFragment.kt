package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import kotlinx.android.synthetic.main.reading_fragment.*
import javax.inject.Inject

class ReadingFragment: BaseFragment(), ReadingView {

    companion object {
        fun newInstance(): Fragment = ReadingFragment()
    }

    override val layout = R.layout.reading_fragment

    @Inject
    lateinit var presenter: ReadingPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
    }

    override fun showBook(name: String?) {
        readingHeader.text = name
    }
}