package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.presentation.core.BaseFragment
import com.wxxtfxrmx.spritzreader.presentation.core.isGranted
import com.wxxtfxrmx.spritzreader.presentation.core.requestPermission
import kotlinx.android.synthetic.main.library_fragment.*
import javax.inject.Inject

class LibraryFragment : BaseFragment(), LibraryView {

	companion object {
		fun newInstance(): Fragment =
			LibraryFragment()

		private const val REQUEST_WRITE_PERMISSION = 666
	}

	override val layout = R.layout.library_fragment

	@Inject
	lateinit var presenter: LibraryPresenter

	private lateinit var adapter: LibraryAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val gridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
		adapter = LibraryAdapter(presenter::onBookClicked)
		booksList.layoutManager = gridLayoutManager
		booksList.addItemDecoration(BookItemDecorator())
		booksList.adapter = adapter

		presenter.attachView(this)
	}

	override fun showBooks(books: List<Book>) {
		booksList.isVisible = true
		noBooksLayout.isVisible = false
		progress.isVisible = false
		adapter.items = books
	}

	override fun showBooksNotFound() {
		booksList.isVisible = false
		progress.isVisible = false
		noBooksLayout.isVisible = true
	}

	override fun showProgress() {
		progress.isVisible = true
		noBooksLayout.isVisible = false
	}

	override fun hideProgress() {
		progress.isVisible = false
	}

	override fun requestWritePermission() {
		requestPermission(
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			REQUEST_WRITE_PERMISSION,
			onInstantGrand = { presenter.onWritePermissionGranted(true) },
			onPermissionDismiss = ::showBooksNotFound
		)

	}

	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray
	) {

		if (requestCode == REQUEST_WRITE_PERMISSION) {
			presenter.onWritePermissionGranted(grantResults.isGranted())
		}
	}
}