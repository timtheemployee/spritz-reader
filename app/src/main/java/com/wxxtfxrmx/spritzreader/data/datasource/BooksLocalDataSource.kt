package com.wxxtfxrmx.spritzreader.data.datasource

import android.content.ContentValues
import androidx.core.database.getStringOrNull
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.COVER
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.DESCRIPTION
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.LAST_PAGE
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.NAME
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.PATH
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.PROGRESS
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.TABLE_NAME
import com.wxxtfxrmx.spritzreader.data.db.BooksDataBaseContract.WORD_ON_PAGE
import com.wxxtfxrmx.spritzreader.data.db.BooksSqliteStorage
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import javax.inject.Inject

interface BooksLocalDataSource {

	fun get(): List<Book>

	fun update(book: Book)

	fun exists(book: Book): Boolean
}

class BooksLocalDataSourceImpl @Inject constructor(
	private val storage: BooksSqliteStorage
) : BooksLocalDataSource {

	override fun get(): List<Book> {
		val projection = arrayOf(PATH, NAME, COVER, PROGRESS, DESCRIPTION, LAST_PAGE, WORD_ON_PAGE)
		val sortOrder = "$PROGRESS DESC"

		val cursor = storage.readableDatabase.query(
			TABLE_NAME,
			projection,
			null,
			null,
			null,
			null,
			sortOrder
		)

		val books = mutableListOf<Book>()

		with(cursor) {
			while (moveToNext()) {
				val book = Book(
					path = getString(cursor.getColumnIndexOrThrow(PATH)),
					name = getString(cursor.getColumnIndexOrThrow(NAME)),
					cover = getStringOrNull(cursor.getColumnIndexOrThrow(COVER)),
					progress = getInt(cursor.getColumnIndex(PROGRESS)),
					description = getString(cursor.getColumnIndexOrThrow(DESCRIPTION)),
					lastPage = getInt(cursor.getColumnIndexOrThrow(LAST_PAGE)),
					wordOnPage = getInt(cursor.getColumnIndexOrThrow(WORD_ON_PAGE))
				)

				books.add(book)
			}

			close()
		}

		return books
	}

	override fun update(book: Book) {
		fun Book.toContentValues(): ContentValues =
			ContentValues().apply {
				put(PATH, path)
				put(NAME, name)
				put(COVER, cover)
				put(PROGRESS, progress)
				put(DESCRIPTION, description)
				put(LAST_PAGE, lastPage)
				put(WORD_ON_PAGE, wordOnPage)
			}

		val contentValues = book.toContentValues()
		val selectionQuery = "$PATH LIKE ?"
		val selectionArgs = arrayOf(book.path)

		storage.writableDatabase.delete(
			TABLE_NAME,
			selectionQuery,
			selectionArgs
		)

		storage.writableDatabase.insert(
			TABLE_NAME,
			null,
			contentValues
		)
	}

	override fun exists(book: Book): Boolean {
		val cursor = storage.readableDatabase.query(
			TABLE_NAME,
			arrayOf(PATH),
			null,
			null,
			null,
			null,
			null
		)

		return if (cursor.count > 0) {
			cursor.close()
			true
		} else {
			cursor.close()
			false
		}
	}
}