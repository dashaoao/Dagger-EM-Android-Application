package com.dashaoao.home.di

import com.dashaoao.core.di.app.First
import com.dashaoao.core.di.app.Second
import com.dashaoao.home.data.HomeRepositoryImpl
import com.dashaoao.home.data.api.ChannelsApi
import com.dashaoao.home.data.api.StreamsApi
import com.dashaoao.home.domain.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class HomeDomainModule {
    @Provides
    fun provideHomeRepository(@First firstApi: ChannelsApi, @Second secondApi: StreamsApi): HomeRepository {
        return HomeRepositoryImpl(firstApi, secondApi)
    }
}
