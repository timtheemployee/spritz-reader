package com.wxxtfxrmx.spritzreader.navigation

interface Navigator {

    fun execute(command: Command)

}

sealed class Command {
    class Open(val destination: Destination): Command()
    object Pop: Command()
}