package com.wxxtfxrmx.spritzreader.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecentFilesFragment: Fragment() {

    companion object {
        fun newInstance(): Fragment = RecentFilesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        TextView(requireContext()).apply {
            text = this@RecentFilesFragment::class.java.simpleName
        }
}