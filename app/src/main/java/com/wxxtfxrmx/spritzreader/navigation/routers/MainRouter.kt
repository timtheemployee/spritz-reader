package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.di.ParentNavigator
import com.wxxtfxrmx.spritzreader.navigation.Command.*
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import javax.inject.Inject

class MainRouter @Inject constructor(
	@ParentNavigator private val navigator: Navigator
) {

	fun openTabsScreen() {
		navigator.execute(Open(Destination.TabsScreen))
	}
}