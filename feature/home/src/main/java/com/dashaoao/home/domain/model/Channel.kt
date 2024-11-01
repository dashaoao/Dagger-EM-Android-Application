package com.dashaoao.home.domain.model

data class Channel(
    val id: String,
    val title: String,
    val topics: List<String>?,
)
