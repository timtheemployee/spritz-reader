package com.wxxtfxrmx.spritzreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.spritzreader.ui.screens.NavigationFragment

class SpritzActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spritz_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, NavigationFragment.newInstance())
            .commitNow()
    }
}