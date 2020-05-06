package com.wxxtfxrmx.spritzreader.presentation.spritz

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import kotlinx.android.synthetic.main.spritz_fragment.*
import javax.inject.Inject

class SpritzFragment : BaseFragment(), SpritzView {

	companion object {
		fun newInstance(): Fragment =
			SpritzFragment()
	}

	override val layout = R.layout.spritz_fragment

	private val renderHandler = Handler()

	private val onRenderCompleteTask = Runnable {
		presenter.onRenderComplete()
	}

	@Inject
	lateinit var presenter: SpritzPresenter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		presenter.attachView(this)

		actionButton.setOnClickListener {
			presenter.onActionButtonClicked()
		}

		back.setOnClickListener {
			presenter.onBackPressed()
		}
	}

	override fun onResume() {
		super.onResume()
		presenter.onResume()
	}

	override fun onPause() {
		super.onPause()
		showPausedState()
	}

	override fun showResumedState(millis: Long) {
		renderHandler.postDelayed(onRenderCompleteTask, millis)
		actionButton.setImageResource(R.drawable.ic_pause)
	}

	override fun showPausedState() {
		renderHandler.removeCallbacks(onRenderCompleteTask)
		actionButton.setImageResource(R.drawable.ic_play)
	}

	override fun initialRenderWord(word: String) {
		spritz.text = word
	}

	override fun renderWord(word: String, millis: Long) {
		spritz.text = word
		renderHandler.postDelayed(onRenderCompleteTask, millis)
	}

	override fun exit() {
		renderHandler.removeCallbacks(onRenderCompleteTask)
		requireActivity().onBackPressed()
	}
}