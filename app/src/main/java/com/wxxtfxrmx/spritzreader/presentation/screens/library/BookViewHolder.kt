package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import kotlinx.android.synthetic.main.library_item.view.*

class BookViewHolder(
	parent: ViewGroup,
	private val onBookClickListener: (Book) -> Unit
) : RecyclerView.ViewHolder(
	LayoutInflater.from(parent.context).inflate(R.layout.library_item, null)
) {

	fun bind(book: Book) {
		with(itemView) {
			title.text = book.name
			bookProgress.progress = book.progress.toInt()
			progressPercent.text = "${book.progress}%"
			cover.showCover(book.cover)

			setOnClickListener { onBookClickListener(book) }
		}
	}

	private fun ImageView.showCover(cover: String?) {
		clipToOutline = true
		val bitmap = BitmapFactory.decodeFile(cover)

		bitmap?.let(::setImageBitmap)
	}
}