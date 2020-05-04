package com.wxxtfxrmx.spritzreader.presentation.screens.settings

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wxxtfxrmx.spritzreader.R

class SettingsBottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(): DialogFragment =
            SettingsBottomSheetFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundedBottomSheetDialogTheme)
    }

    override fun onAttach(activity: Activity) {
        //AndroidSupportInjection.inject(this)
        super.onAttach(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.settings_fragment, container, false)

}