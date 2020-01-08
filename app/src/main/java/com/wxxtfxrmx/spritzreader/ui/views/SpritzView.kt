package com.wxxtfxrmx.spritzreader.ui.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class SpritzView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defAttrStyle: Int = 0
) : View(context, attrs, defStyleAttr, defAttrStyle) {

    private companion object {
        const val EVEN_DIVIDER = 2
    }


    var text: String? = null
        set(value) {
            value?.let {
                applyFocusPosition(it)
                field = value
            }
        }

    private fun applyFocusPosition(text: String) {
        if(text.length % EVEN_DIVIDER == 0) {
            focusPosition = text.length / EVEN_DIVIDER - 1
        } else {
            focusPosition = (text.length - 1 / EVEN_DIVIDER) - 1
        }
    }

    private var focusPosition: Int = 0


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}