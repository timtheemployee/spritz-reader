package com.wxxtfxrmx.spritzreader.presentation.screens.reading

import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import com.wxxtfxrmx.spritzreader.presentation.screens.settings.SettingsBottomSheetFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.reading_fragment.*
import javax.inject.Inject

class ReadingFragment : BaseFragment(), ReadingView, HasAndroidInjector {

	companion object {
		fun newInstance(): Fragment = ReadingFragment()
	}

	override val layout = R.layout.reading_fragment

	private val chipsVisibilityHandler = Handler()
	private val chipsVisibilityTask = Runnable {
		actionChips.isVisible = true
	}

	@Inject
	lateinit var presenter: ReadingPresenter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		presenter.attachView(this)


		contentScrollContainer.setOnTouchListener { _, event ->
			if (event.action == MotionEvent.ACTION_DOWN) {
				actionChips.isVisible = false
				chipsVisibilityHandler.removeCallbacks(chipsVisibilityTask)
			} else if (event.action == MotionEvent.ACTION_UP) {
				chipsVisibilityHandler.postDelayed(chipsVisibilityTask, 700L)
			}

			false
		}

		settingsChip.setOnClickListener {
			val settingsFragment = SettingsBottomSheetFragment.newInstance()
			settingsFragment.show(
				childFragmentManager,
				SettingsBottomSheetFragment::class.java.simpleName
			)
		}

		startReadingChip.setOnClickListener {
			presenter.onStartReadingClick()
		}
	}

	override fun renderPage(content: String?) {
		pageContent.text = content
	}

	@Inject
	lateinit var supportFragmentInjector: DispatchingAndroidInjector<Any>

	override fun androidInjector(): AndroidInjector<Any> =
		supportFragmentInjector

}