package com.wxxtfxrmx.spritzreader.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.ui.screens.NavigationFragment

class GlobalNavigator(
    private val fragmentManager: FragmentManager,
    @IdRes private val containerId: Int
): Navigator {

    override fun execute(command: Command) {
        when(command) {
            is Command.Open -> open(command.destination)
        }
    }

    private fun open(destination: Destination) {
        val fragment = getFragment(destination)

        if (fragment == null) {
            return
            //TODO Handle Navigation in tab navigator
        }

        fragmentManager.beginTransaction().apply {
            replace(containerId, fragment, fragment::class.java.simpleName)
            commitNow()
        }
    }

    private fun getFragment(destination: Destination): Fragment? =
        when(destination) {
            Destination.TabsScreen -> NavigationFragment.newInstance()
            else -> null
        }
}