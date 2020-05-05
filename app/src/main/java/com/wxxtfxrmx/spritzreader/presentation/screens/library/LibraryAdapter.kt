package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.spritzreader.domain.entity.Book

class LibraryAdapter(
	private val onBookClickListener: (Book) -> Unit
) : RecyclerView.Adapter<BookViewHolder>() {

	var items: List<Book> = emptyList()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
		BookViewHolder(parent, onBookClickListener)

	override fun getItemCount(): Int = items.size

	override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
		holder.bind(items[position])
	}
}