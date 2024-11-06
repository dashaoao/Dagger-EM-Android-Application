package com.dashaoao.home.di

import com.dashaoao.core.di.app.First
import com.dashaoao.core.di.app.Second
import com.dashaoao.core.domain.HomeDeps
import com.dashaoao.home.data.api.ChannelsApi
import com.dashaoao.home.data.api.StreamsApi
import dagger.Module
import dagger.Provides

@Module
object HomeDataModule {

    @[Provides Home First]
    fun provideApiServiceFirst(@First retrofit: HomeDeps): ChannelsApi {
        return retrofit.getRetrofit().create(ChannelsApi::class.java)
    }

    @[Provides Home Second]
    fun provideApiServiceSecond(@Second retrofit: HomeDeps): StreamsApi {
        return retrofit.getRetrofit().create(StreamsApi::class.java)
    }
}
