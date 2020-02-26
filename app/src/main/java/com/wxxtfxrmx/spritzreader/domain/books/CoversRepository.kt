package com.wxxtfxrmx.spritzreader.domain.books

import java.io.File

interface CoversRepository {
    fun get(): Cover

    fun createCover(file: File)
}