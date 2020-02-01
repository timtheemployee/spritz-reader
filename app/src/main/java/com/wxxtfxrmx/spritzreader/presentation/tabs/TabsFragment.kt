package com.wxxtfxrmx.spritzreader.presentation.tabs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import com.wxxtfxrmx.spritzreader.presentation.screens.BookMarksFragment
import com.wxxtfxrmx.spritzreader.presentation.screens.LibraryFragment
import com.wxxtfxrmx.spritzreader.presentation.screens.RecentFilesFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.navigation_fragment.*
import java.lang.IllegalArgumentException
import javax.inject.Inject

class TabsFragment : BaseFragment(), TabsView {

    companion object {
        fun newInstance(): Fragment =
            TabsFragment()

    }

    override val layout = R.layout.navigation_fragment

    @Inject
    lateinit var presenter: TabsPresenter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)


        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.library -> presenter.onLibraryClicked()
                R.id.recent -> presenter.onRecentClicked()
                R.id.bookmarks -> presenter.onBookmarksClicked()
                else -> throw IllegalArgumentException("navigation not support $item, is it added in root navigation?")
            }


            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}