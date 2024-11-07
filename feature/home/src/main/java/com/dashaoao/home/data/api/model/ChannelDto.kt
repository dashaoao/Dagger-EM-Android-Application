package com.dashaoao.home.data.api.model

import com.dashaoao.home.domain.model.Channel

class ChannelDto (
    val id: Int,
    val name: String,
)

fun ChannelDto.toDomain() = Channel(
    id = id.toString(),
    title = name,
    topics = emptyList()
)
