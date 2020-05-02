package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Paint
import android.graphics.Shader
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
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
            annotation.text = book.description
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