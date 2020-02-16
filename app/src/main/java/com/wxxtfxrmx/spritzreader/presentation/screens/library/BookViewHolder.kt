package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.library.Book
import com.wxxtfxrmx.spritzreader.domain.library.Cover
import kotlinx.android.synthetic.main.library_item.view.*

class BookViewHolder(parent: ViewGroup,
                     private val onBookClickListener: (Book) -> Unit): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.library_item, null)
) {

    fun bind(item: LibraryItem) {
        with(itemView) {
            title.text = item.book.name
            annotation.text = item.description.text
            cover.showCover(item.cover)

            setOnClickListener { onBookClickListener(item.book) }
        }
    }

    private fun ImageView.showCover(cover: Cover?) {
        val bitmap = BitmapFactory.decodeFile(cover?.path)

        bitmap?.let(this::setImageBitmap)
    }
}