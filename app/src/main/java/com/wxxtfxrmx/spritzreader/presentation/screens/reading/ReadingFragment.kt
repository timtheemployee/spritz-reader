package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment

class ReadingFragment: BaseFragment() {

    companion object {
        fun newInsance(): Fragment = ReadingFragment()
    }

    override val layout = R.layout.reading_fragment
}