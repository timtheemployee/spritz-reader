package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.library.Book
import kotlinx.android.synthetic.main.library_item.view.*

class BookViewHolder(parent: ViewGroup,
                     private val onBookClickListener: (Book) -> Unit): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.library_item, null)
) {

    fun bind(book: Book) {
        with(itemView) {
            title.text = book.name
            annotation.text = book.path
            setOnClickListener { onBookClickListener(book) }
        }
    }
}