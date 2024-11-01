package com.dashaoao.home.di

import com.dashaoao.home.data.HomeRepositoryImpl
import com.dashaoao.home.data.api.ChannelsApi
import com.dashaoao.home.data.api.StreamsApi
import com.dashaoao.home.domain.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class HomeDomainModule {
    @Provides
    fun provideHomeRepository(firstApi: ChannelsApi, secondApi: StreamsApi): HomeRepository {
        return HomeRepositoryImpl(firstApi, secondApi)
    }
}
