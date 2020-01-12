package com.wxxtfxrmx.spritzreader.ui.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.wxxtfxrmx.spritzreader.BuildConfig
import com.wxxtfxrmx.spritzreader.R

class SpritzView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defAttrStyle: Int = 0
) : View(context, attrs, defStyleAttr, defAttrStyle) {

    var text: String? = null
        set(value) {
            value?.let {
                spritzString = SpritzString(it.toLowerCase())
                field = value
                invalidate()
            }
        }

    //TODO(" REMOVE IT LATER DUDE ")
    var debugMode: Boolean = false

    private var spritzString: SpritzString? = null

    private val focusPaint: Paint
    private val commonPaint: Paint
    private val linePaint: Paint

    private val defaultTextSize: Float
    private val defaultVerticalPadding: Float
    private val verticalLineLength: Float

    init {
        val attributes =
            context.obtainStyledAttributes(attrs, R.styleable.SpritzView, defStyleAttr, 0)

        defaultTextSize = attributes.getDimension(R.styleable.SpritzView_textSize, 0f)

        focusPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = attributes.getColor(R.styleable.SpritzView_focusColor, 0)
            textSize = defaultTextSize
        }

        commonPaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = attributes.getColor(R.styleable.SpritzView_textColor, 0)
            textSize = defaultTextSize
        }

        linePaint = Paint(ANTI_ALIAS_FLAG).apply {
            color = attributes.getColor(R.styleable.SpritzView_textColor, 0)
            strokeWidth = 2f.dpToPx(context)
        }

        attributes.recycle()
        defaultVerticalPadding = 16f.dpToPx(context)
        verticalLineLength = 16f.dpToPx(context)
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
            spritzString?.let { spritzString ->
                val textHeight = focusPaint.fontMetrics.run { descent - ascent + leading }

                val focusTextWidth = focusPaint.measureText(spritzString.focus()) / 2
                val focusXPosition = width / 2f - focusTextWidth
                val focusYPosition = height / 2f + textHeight / 4

                if(debugMode) {
                    drawDebugLines()
                }

                drawLine(0f, 0f, width.toFloat(), 0f, linePaint)
                drawLine(width/ 2f, 0f, width/ 2f, verticalLineLength, linePaint)

                drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), linePaint)
                drawLine(width / 2f, height.toFloat(), width / 2f, height - verticalLineLength, linePaint)

                drawText(spritzString.focus(), focusXPosition, focusYPosition, focusPaint)
                drawText(spritzString.start(), focusXPosition - commonPaint.measureText(spritzString.start()), focusYPosition, commonPaint)
                drawText(spritzString.end(), focusXPosition + commonPaint.measureText(spritzString.focus()), focusYPosition, commonPaint)
            }
        }
    }

    private fun Canvas.drawDebugLines() {
        drawLine(width / 2f, 0f, width / 2f, height.toFloat(), commonPaint)
        drawLine(0f, height / 2f, width.toFloat(), height / 2f, commonPaint)
    }


    private fun Float.dpToPx(context: Context): Float =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            context.resources.displayMetrics
        )
}
