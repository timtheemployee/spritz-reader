package com.wxxtfxrmx.spritzreader.di

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import com.wxxtfxrmx.spritzreader.navigation.routers.TabRouterImpl
import com.wxxtfxrmx.spritzreader.navigation.tabs.TabsNavigator
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsPresenter

class TabsFragmentInjector(private val parentNavigator: Navigator) : FragmentManager.FragmentLifecycleCallbacks() {

    private lateinit var presenter: TabsPresenter

    override fun onFragmentPreAttached(fm: FragmentManager, fragment: Fragment, context: Context) {
        super.onFragmentPreAttached(fm, fragment, context)

        if (fragment !is TabsFragment) return

        val navigator = TabsNavigator(
            fragmentManager = fragment.childFragmentManager,
            container = R.id.tabsContainer,
            parentNavigator = parentNavigator
        )

        val router = TabRouterImpl(
            navigator
        )

        presenter = TabsPresenter(router)

        fragment.presenter = presenter
        Log.e("TAG", "OnFragmentPreAttached")
    }
}