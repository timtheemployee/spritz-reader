package com.wxxtfxrmx.spritzreader.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.CONTRACT_VERSION
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.CREATE_TABLE_QUERY
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.DROP_TABLE_QUERY
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.SPRITZ_DATABASE
import javax.inject.Inject

class BooksSqliteStorage @Inject constructor(
    context: Context
) : SQLiteOpenHelper(
    context,
    SPRITZ_DATABASE,
    null,
    CONTRACT_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_QUERY)
        onCreate(db)
    }
}