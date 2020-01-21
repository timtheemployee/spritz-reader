package com.wxxtfxrmx.spritzreader.navigation

sealed class Destination {
    object LibraryScreen: Destination()
    object RecentScreen: Destination()
    object BookmarksScreen: Destination()
    object TabsScreen: Destination()
}