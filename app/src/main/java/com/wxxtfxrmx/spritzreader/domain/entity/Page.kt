package com.wxxtfxrmx.spritzreader.domain.entity

data class Page(
	val content: String
) {

	fun toList(): List<String> =
		content.split(" ")

	fun lastIndex(): Int =
		toList().size - 1
}