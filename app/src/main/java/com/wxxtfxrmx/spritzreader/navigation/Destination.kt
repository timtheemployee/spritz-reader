package com.wxxtfxrmx.spritzreader.navigation

sealed class Destination {

    object LibraryScreen: Destination()
    object BookMarksScreen: Destination()
    object RecentScreen: Destination()
    object TabsScreen: Destination()
}