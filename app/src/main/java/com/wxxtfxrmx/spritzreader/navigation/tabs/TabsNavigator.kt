package com.wxxtfxrmx.spritzreader.navigation.tabs

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.navigation.Command
import com.wxxtfxrmx.spritzreader.navigation.Command.Open
import com.wxxtfxrmx.spritzreader.navigation.Command.Pop
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import com.wxxtfxrmx.spritzreader.presentation.screens.library.LibraryFragment
import com.wxxtfxrmx.spritzreader.presentation.screens.reading.ReadingFragment

class TabsNavigator(
    private val fragmentManager: FragmentManager,
    @IdRes private val container: Int,
    private val parentNavigator: Navigator
): Navigator {


    override fun execute(command: Command) {
        when(command) {
            is Open -> open(command.destination)
            is Pop -> pop()
        }
    }

    private fun open(destination: Destination) {
        val fragment = getFragment(destination)

        if (fragment == null) {
            executeOnParent(Open(destination))
            return
        }


        fragmentManager.beginTransaction().apply {
            replace(container, fragment, destination::class.java.simpleName)
            commitNow()
        }
    }

    private fun pop() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            executeOnParent(Pop)
        }
    }

    private fun executeOnParent(command: Command) {
        parentNavigator.execute(command)
    }

    private fun getFragment(destination: Destination): Fragment? =
        when (destination) {
            is Destination.LibraryScreen -> LibraryFragment.newInstance()
            is Destination.ReadingScreen -> ReadingFragment.newInstance()
            else -> null
        }
}