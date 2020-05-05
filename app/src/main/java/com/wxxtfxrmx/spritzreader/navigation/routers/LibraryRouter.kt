package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import javax.inject.Inject

class LibraryRouter @Inject constructor(
	private val navigator: Navigator
) {

	fun openReadingScreen() {
		navigator.execute(Command.Open(Destination.ReadingScreen))
	}
}