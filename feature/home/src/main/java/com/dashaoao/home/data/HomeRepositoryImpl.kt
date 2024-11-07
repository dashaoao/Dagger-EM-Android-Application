package com.dashaoao.home.data

import com.dashaoao.home.data.api.ChannelsApi
import com.dashaoao.home.data.api.StreamsApi
import com.dashaoao.home.domain.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val serviceFirst: ChannelsApi,
    private val serviceSecond: StreamsApi
) : HomeRepository {

    override suspend fun getData(): Flow<String> = flow {
        val channelResult = serviceFirst.getChannelById("1")
        val channelName = if (channelResult.isSuccess) {
            channelResult.getOrNull()?.name
        } else {
            emit("error")
            return@flow
        }

        val channelResult2 = serviceSecond.getChannelById("2")
        val channelName2 = if (channelResult2.isSuccess) {
            channelResult2.getOrNull()?.name
        } else {
            emit("error")
            return@flow
        }

        emit("$channelName $channelName2")
    }
}
