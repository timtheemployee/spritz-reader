package com.wxxtfxrmx.spritzreader.presentation.core

import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.requestPermission(permission: String,
							   requestCode: Int,
							   onInstantGrand: (() -> Unit)? = null) {

	if (ContextCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
		ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), requestCode)
	} else {
		onInstantGrand?.invoke()
	}
}

fun IntArray.isGranted(): Boolean =
	this.isNotEmpty() && this[0] == PackageManager.PERMISSION_GRANTED