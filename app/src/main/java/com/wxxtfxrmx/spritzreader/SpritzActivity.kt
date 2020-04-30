package com.wxxtfxrmx.spritzreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.spritzreader.navigation.routers.MainRouter

class SpritzActivity : AppCompatActivity() {

    //lateinit var mainRouter: MainRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spritz_activity)
      //  mainRouter.openTabsScreen()
    }
}