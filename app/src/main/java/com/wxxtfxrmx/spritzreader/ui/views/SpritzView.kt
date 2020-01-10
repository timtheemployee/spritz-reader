package com.wxxtfxrmx.spritzreader.ui.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.wxxtfxrmx.spritzreader.R

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

    private var focusPosition: Int = 0

    private val focusPaint: Paint
    private val paint: Paint

    private val defaultTextSize: Float
    private val defaultVerticalPadding: Float

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SpritzView, defStyleAttr, 0)

        defaultTextSize = attributes.getDimension(R.styleable.SpritzView_textSize, 0f)

        focusPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = attributes.getColor(R.styleable.SpritzView_focusColor, 0)
            textSize = defaultTextSize
        }

        paint = Paint(ANTI_ALIAS_FLAG).apply {
            color = attributes.getColor(R.styleable.SpritzView_textColor, 0)
            textSize = defaultTextSize
        }

        attributes.recycle()
        defaultVerticalPadding = 16f.dpToPx(context)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val desiredWidth = width
        val desiredHeight = defaultVerticalPadding * 2 + defaultTextSize

        val measuredWidth = applyMeasureSpecs(desiredWidth, widthMeasureSpec)
        val measuredHeight = applyMeasureSpecs(desiredHeight.toInt(), heightMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    private fun applyMeasureSpecs(param: Int, spec: Int): Int {
        val mode = MeasureSpec.getMode(spec)
        val specSize = MeasureSpec.getSize(spec)

        return when (mode) {
            MeasureSpec.EXACTLY -> specSize
            MeasureSpec.AT_MOST -> if (param < specSize) {
                param
            } else {
                specSize
            }

            MeasureSpec.UNSPECIFIED -> param
            else -> param
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {

            text?.let {
                val start = it.start()
                drawText(start, startX(start), middleY(), paint)
                drawText(it.focus(), middleX(), middleY(), focusPaint)
                drawText(it.end(), endX(middleX()), middleY(), paint)
            }
        }
    }

    private fun middleX(): Float =
        (width / 2) - defaultTextSize / 2

    private fun middleY(): Float =
        (height / 2).toFloat()

    private fun startX(startText: String): Float =
        middleX() - startText.length * (defaultTextSize - 1)

    private fun endX(focusPosition: Float): Float =
        focusPosition + defaultTextSize

    private fun String.focus(): String =
        this[focusPosition].toString()

    private fun String.start(): String =
        this.substring(0, focusPosition)

    private fun String.end(): String =
        this.substring(focusPosition + 1)

    private fun applyFocusPosition(text: String) {
        focusPosition = if (text.length % EVEN_DIVIDER == 0) {
            (text.length / EVEN_DIVIDER) - 1
        } else {
            (text.length - 1 / EVEN_DIVIDER) - 1
        }
    }

    private fun Float.dpToPx(context: Context): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)
}
