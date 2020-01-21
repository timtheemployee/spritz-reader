package com.wxxtfxrmx.spritzreader.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BookMarksFragment: Fragment() {

    companion object {
        fun newInstance(): Fragment = BookMarksFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        TextView(requireContext()).apply {
            text = this@BookMarksFragment::class.java.simpleName
        }
}