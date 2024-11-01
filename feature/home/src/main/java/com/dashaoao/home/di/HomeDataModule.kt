package com.dashaoao.home.di

import com.dashaoao.home.data.api.ChannelsApi
import com.dashaoao.home.data.api.StreamsApi
import dagger.Module
import dagger.Provides

@Module
class HomeDataModule {

    @[Provides Home]
    fun provideApiServiceFirst(deps: HomeDeps): ChannelsApi {
        return deps.getRetrofitFirst().create(ChannelsApi::class.java)
    }

    @[Provides Home]
    fun provideApiServiceSecond(deps: HomeDeps): StreamsApi {
        return deps.getRetrofitSecond().create(StreamsApi::class.java)
    }
}
