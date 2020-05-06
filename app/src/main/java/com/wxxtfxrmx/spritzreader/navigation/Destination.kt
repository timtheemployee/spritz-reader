package com.wxxtfxrmx.spritzreader.navigation

sealed class Destination {
	object LibraryScreen : Destination()
	object ReadingScreen : Destination()
	object TabsScreen : Destination()
	object SpritzScreen: Destination()
}