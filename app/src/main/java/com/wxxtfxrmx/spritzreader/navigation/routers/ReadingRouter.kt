package com.wxxtfxrmx.spritzreader.navigation.routers

import com.wxxtfxrmx.spritzreader.navigation.Command
import com.wxxtfxrmx.spritzreader.navigation.Destination
import com.wxxtfxrmx.spritzreader.navigation.Navigator
import javax.inject.Inject

class ReadingRouter @Inject constructor(
	private val navigator: Navigator
) {

	fun openSpritzScreen() {
		navigator.execute(Command.Open(Destination.SpritzScreen))
	}
}