package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BookItemDecorator : RecyclerView.ItemDecoration() {

	private companion object {

		const val MARGIN_8 = 8
		const val MARGIN_16 = 16

	}

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		val viewPosition = parent.getChildAdapterPosition(view)

		val onRightColumn = viewPosition % 2 == 1


		outRect.bottom = MARGIN_8
		outRect.top = MARGIN_8

		if (onRightColumn) {
			outRect.right = MARGIN_16
			outRect.left = MARGIN_8
		} else {
			outRect.left = MARGIN_16
			outRect.right = MARGIN_8
		}
	}
}