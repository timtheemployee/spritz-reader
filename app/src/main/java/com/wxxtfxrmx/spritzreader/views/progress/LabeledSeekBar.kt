package com.wxxtfxrmx.spritzreader.views.progress

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.wxxtfxrmx.spritzreader.R
import kotlinx.android.synthetic.main.labeled_seekbar.view.*

class LabeledSeekBar @JvmOverloads constructor(
	context: Context,
	attributeSet: AttributeSet? = null,
	defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

	private companion object {
		const val TAG = "LabeledSeekBar"
	}

	private val seekBarListener = LabeledSeekBarSlideListener().apply {
		setProgressChangedHandler { progress, _ ->
			applyTranslationToLabel(progress)
		}

		setStartTrackingHandler { progressLabel.isVisible = true }
	}

	init {
		View.inflate(context, R.layout.labeled_seekbar, this)

		seekBar.setOnSeekBarChangeListener(seekBarListener)
	}

	private fun applyTranslationToLabel(progress: Int) {
		val layoutParams = progressLabel.layoutParams as LayoutParams
		layoutParams.horizontalBias = when {
			progress <= 100  -> 0.05f
			progress >= 1000 -> 0.95f
			else             -> progress / 1000f
		}

		progressLabel.layoutParams = layoutParams
		progressLabel.text = "$progress сл/м"
		if (progressLabel.visibility == View.INVISIBLE) progressLabel.visibility = View.VISIBLE
		invalidate()
	}
}

class LabeledSeekBarSlideListener : SeekBar.OnSeekBarChangeListener {

	private var startTrackingHandler: ((SeekBar?) -> Unit)? = null
	private var stopTrackingHandler: ((SeekBar?) -> Unit)? = null
	private var progressChangedHandler: ((Int, Boolean) -> Unit)? = null

	fun setStartTrackingHandler(handler: (SeekBar?) -> Unit) {
		startTrackingHandler = handler
	}

	fun setStopTrackingHandler(handler: (SeekBar?) -> Unit) {
		stopTrackingHandler = handler
	}

	fun setProgressChangedHandler(handler: (Int, Boolean) -> Unit) {
		progressChangedHandler = handler
	}

	override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
		progressChangedHandler?.invoke(progress, fromUser)
	}

	override fun onStartTrackingTouch(seekBar: SeekBar?) {
		startTrackingHandler?.invoke(seekBar)
	}

	override fun onStopTrackingTouch(seekBar: SeekBar?) {
		stopTrackingHandler?.invoke(seekBar)
	}
}