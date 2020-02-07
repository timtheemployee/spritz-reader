package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.library.Book

class BookViewHolder(parent: ViewGroup,
                     private val onBookClickListener: (Book) -> Unit): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.library_fragment, null)
) {

    fun bind(book: Book) {
        itemView.setOnClickListener { onBookClickListener(book) }
    }
}