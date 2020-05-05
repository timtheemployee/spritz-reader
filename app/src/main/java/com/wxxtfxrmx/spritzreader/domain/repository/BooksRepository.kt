package com.wxxtfxrmx.spritzreader.domain.repository

import com.wxxtfxrmx.spritzreader.domain.entity.Book

interface BooksRepository {

	fun get(): List<Book>

	fun existing(book: Book): Boolean

	fun update(book: Book)
}