package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class LibraryFragment: Fragment() {

    companion object {
        fun newInstance(): Fragment =
            LibraryFragment()
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        TextView(requireContext()).apply {
            text = this@LibraryFragment::class.java.simpleName
        }
}