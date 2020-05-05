package com.wxxtfxrmx.spritzreader.navigation

sealed class Command {
	class Open(val destination: Destination) : Command()
	object Pop : Command()
}