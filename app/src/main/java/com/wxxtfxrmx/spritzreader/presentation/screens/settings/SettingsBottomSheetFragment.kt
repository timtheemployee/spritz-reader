package com.wxxtfxrmx.spritzreader.presentation.screens.settings

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wxxtfxrmx.spritzreader.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.settings_fragment.*
import javax.inject.Inject

class SettingsBottomSheetFragment : BottomSheetDialogFragment(), SettingsView {

	companion object {
		fun newInstance(): DialogFragment =
			SettingsBottomSheetFragment()
	}

	@Inject
	lateinit var presenter: SettingsPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundedBottomSheetDialogTheme)
	}

	override fun onAttach(context: Context) {
		AndroidSupportInjection.inject(this)
		super.onAttach(context)
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? =
		inflater.inflate(R.layout.settings_fragment, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		presenter.attachView(this)
	}

	override fun showWordsInMinute(wordsInMinute: Int) {
		wordsInMinuteSeekbar.progress = wordsInMinute
	}

	override fun onCancel(dialog: DialogInterface) {
		super.onCancel(dialog)
		presenter.onCancel(wordsInMinuteSeekbar.progress)
	}
}