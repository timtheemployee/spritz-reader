package com.wxxtfxrmx.spritzreader.domain.library

import java.io.File

interface CoversRepository {
    fun get(): Cover

    fun createCover(file: File)
}