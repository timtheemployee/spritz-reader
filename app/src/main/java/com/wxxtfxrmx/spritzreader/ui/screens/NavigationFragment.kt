package com.wxxtfxrmx.spritzreader.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.ui.core.BaseFragment
import kotlinx.android.synthetic.main.navigation_fragment.*
import java.lang.IllegalArgumentException

class NavigationFragment : BaseFragment() {

    companion object {
        fun newInstance(): Fragment = NavigationFragment()

        const val CURRENT_FRAGMENT_KEY = "currentFragmentKey"
    }

    override val layout = R.layout.navigation_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spritzView.text = "Привет"
        navigation.setOnNavigationItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.library -> LibraryFragment.newInstance()
                R.id.recent -> RecentFilesFragment.newInstance()
                R.id.bookmarks -> BookMarksFragment.newInstance()
                else -> throw IllegalArgumentException("navigation not support $item, is it added in root navigation?")
            }


            showFragment(fragment)
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.spritzContainer, fragment, CURRENT_FRAGMENT_KEY)
            .commitNow()
    }
}