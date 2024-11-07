package com.dashaoao.home.presentation.model

import com.dashaoao.home.domain.model.Channel

data class ChannelsItem(
    val id: String,
    val title: String,
    val expanded: Boolean,
    val topics: List<String>
)

fun Channel.toUI(expanded: Boolean = false) = ChannelsItem(
    id = id,
    title = title,
    expanded = expanded,
    topics = topics ?: emptyList()
)
