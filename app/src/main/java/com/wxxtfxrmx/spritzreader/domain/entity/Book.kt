package com.wxxtfxrmx.spritzreader.domain.entity

import java.io.Serializable

data class Book(
	val path: String,
	val name: String,
	val cover: String? = null,
	val progress: Float = 0f,
	val description: String = "",
	val lastPage: Int = 0,
	val wordOnPage: Int = 0
) : Serializable