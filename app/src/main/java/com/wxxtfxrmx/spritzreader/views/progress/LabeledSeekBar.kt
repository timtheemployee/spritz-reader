package com.wxxtfxrmx.spritzreader.views.progress

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.SeekBar
import com.wxxtfxrmx.spritzreader.R
import kotlinx.android.synthetic.main.labeled_seekbar.view.*

class LabeledSeekBar @JvmOverloads constructor(
	context: Context,
	attributeSet: AttributeSet? = null,
	defStyleAttr: Int = 0,
	defStyleRes: Int = 0
) : RelativeLayout(context, attributeSet, defStyleAttr, defStyleRes) {

	private companion object {
		const val TAG = "LabeledSeekBar"
	}

	private val seekBarListener = LabeledSeekBarSlideListener().apply {
		setProgressChangedHandler { progress, _ ->
			applyTranslationToLabel(progress)
		}
	}

	init {
		View.inflate(context, R.layout.labeled_seekbar, this)

		seekBar.setOnSeekBarChangeListener(seekBarListener)
	}

	private fun applyTranslationToLabel(progress: Int) {
		val difference = seekBar.right - seekBar.left
		val differencePercent = difference * (progress / 100f)
        val positive = progressLabel.x >= differencePercent
		progressLabel.x = if (progressLabel.x + progressLabel.width < seekBar.x + seekBar.width && !positive) {
			differencePercent - progressLabel.width / 2
		} else {
			progressLabel.x
		}

		progressLabel.text = "$progress сл/м"
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