package com.wxxtfxrmx.spritzreader.data.db

object BooksDataBaseContract {

    const val SPRITZ_DATABASE = "SPRITZ_DATABASE"
    const val CONTRACT_VERSION = 1

    const val TABLE_NAME = "Books"
    const val PATH = "path"
    const val NAME = "name"
    const val COVER = "cover"
    const val PROGRESS = "progress"
    const val DESCRIPTION = "description"
    const val LAST_PAGE = "lastPage"
    const val WORD_ON_PAGE = "wordOnPage"

    const val CREATE_TABLE_QUERY = """
        CREATE TABLE IF NOT EXISTS $TABLE_NAME (
        $PATH TEXT PRIMARY KEY,
        $NAME TEXT,
        $COVER TEXT,
        $PROGRESS INTEGER,
        $DESCRIPTION TEXT,
        $LAST_PAGE INTEGER,
        $WORD_ON_PAGE INTEGER )
    """

    const val DROP_TABLE_QUERY = """
        DROP TABLE IF EXISTS $TABLE_NAME
    """
}