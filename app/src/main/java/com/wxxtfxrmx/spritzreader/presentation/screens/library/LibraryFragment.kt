package com.wxxtfxrmx.spritzreader.presentation.screens.library

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wxxtfxrmx.spritzreader.R
import com.wxxtfxrmx.spritzreader.di.ui.LibraryViewModelFactory
import com.wxxtfxrmx.spritzreader.domain.entity.Book
import com.wxxtfxrmx.spritzreader.presentation.core.isGranted
import com.wxxtfxrmx.spritzreader.presentation.core.requestPermission
import kotlinx.android.synthetic.main.library_fragment.*
import javax.inject.Inject

class LibraryFragment : Fragment(R.layout.library_fragment) {

	companion object {
		fun newInstance(): Fragment =
			LibraryFragment()

		private const val REQUEST_WRITE_PERMISSION = 666
	}

	@Inject
	lateinit var factory: LibraryViewModelFactory

	private val viewModel: LibraryViewModel by viewModels(factoryProducer = { factory })

	private val adapter: LibraryAdapter by lazy {
		LibraryAdapter(viewModel::openBook)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val gridLayoutManager = StaggeredGridLayoutManager(2,
			StaggeredGridLayoutManager.VERTICAL)
		booksList.layoutManager = gridLayoutManager
		booksList.addItemDecoration(BookItemDecorator())
		booksList.adapter = adapter

		viewModel.permissionAsked.observe(viewLifecycleOwner, Observer { asked ->
			if (!asked) {
				requestWritePermission()
			} else {
				viewModel.loadBooks()
			}
		})

		viewModel.books.observe(viewLifecycleOwner, Observer { books ->
			adapter.items = books
		})

		viewModel.progress.observe(viewLifecycleOwner, Observer { needShow ->
			progress.isVisible = needShow
		})

		viewModel.booksStub.observe(viewLifecycleOwner, Observer { needShow ->
			noBooksLayout.isVisible = needShow
		})
	}

	private fun requestWritePermission() {
		requestPermission(
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			REQUEST_WRITE_PERMISSION,
			onInstantGrand = { viewModel.loadBooks() },
			onPermissionDismiss = { viewModel.showNoBooksStub() }
		)
	}

	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray
	) {

		if (requestCode == REQUEST_WRITE_PERMISSION) {
			viewModel.loadBooks()
		}
	}
}