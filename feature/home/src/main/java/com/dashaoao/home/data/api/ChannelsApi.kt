package com.dashaoao.home.data.api

import com.dashaoao.home.data.api.model.AllChannelsResponse
import com.dashaoao.home.data.api.model.ChannelDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChannelsApi {
    @GET("streams")
    suspend fun getAllChannels(): Result<AllChannelsResponse>

    @GET("streams/{stream_id}")
    suspend fun getChannelById(@Path("stream_id") channelId: String): Result<ChannelDto>
}
