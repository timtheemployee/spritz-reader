package com.wxxtfxrmx.spritzreader.presentation.core

import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.wxxtfxrmx.spritzreader.R

fun Fragment.requestPermission(permission: String,
							   requestCode: Int,
							   onInstantGrand: (() -> Unit)? = null,
							   onPermissionDismiss: (() -> Unit)? = null) {

	if (ContextCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
		if (requireActivity().shouldShowRequestPermissionRationale(permission)) {
			showPermissionsDialog(
				onPositiveClick = {
					ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), requestCode)
				},
				onNegativeClick = {
					onPermissionDismiss?.invoke()
				})
		} else {
			ActivityCompat.requestPermissions(requireActivity(), arrayOf(permission), requestCode)
		}
	} else {
		onInstantGrand?.invoke()
	}
}

fun Fragment.showPermissionsDialog(onPositiveClick: () -> Unit, onNegativeClick: () -> Unit) {
	AlertDialog.Builder(requireContext())
		.setMessage(getString(R.string.local_storage_explanation))
		.setPositiveButton(getString(R.string.ok)) { _, _ -> onPositiveClick() }
		.setNegativeButton(getString(R.string.cancel)) { _, _ -> onNegativeClick() }
		.create()
		.show()
}

fun IntArray.isGranted(): Boolean =
	this.isNotEmpty() && this[0] == PackageManager.PERMISSION_GRANTED