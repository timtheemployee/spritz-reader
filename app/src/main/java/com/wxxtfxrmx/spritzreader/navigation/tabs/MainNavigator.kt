package com.wxxtfxrmx.spritzreader.navigation.tabs

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wxxtfxrmx.spritzreader.di.ParentContainerId
import com.wxxtfxrmx.spritzreader.di.ParentFragmentManager
import com.wxxtfxrmx.spritzreader.navigation.Command
import com.wxxtfxrmx.spritzreader.navigation.Command.*
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Destination.*
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import com.wxxtfxrmx.spritzreader.presentation.tabs.TabsFragment
import javax.inject.Inject

class MainNavigator @Inject constructor(
	@ParentFragmentManager private val fragmentManager: FragmentManager,
	@ParentContainerId @IdRes private val container: Int
) : Navigator {

	override fun execute(command: Command) {
		when (command) {
			is Open -> open(command.destination)
			is Pop  -> pop()
		}
	}

	private fun pop() {
		if (fragmentManager.backStackEntryCount > 1) {
			fragmentManager.popBackStack()
		}
	}

	private fun open(destination: Destination) {
		val fragment = getFragment(destination)

		fragmentManager.beginTransaction().apply {
			replace(container, fragment, destination::class.java.simpleName)
			commitNow()
		}
	}

	private fun getFragment(destination: Destination): Fragment {
		return when (destination) {
			is TabsScreen -> TabsFragment.newInstance()
			else          -> throw IllegalArgumentException("Destination $destination is not root fragment. Check TabNavigator#getFragment")
		}
	}
}