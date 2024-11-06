package com.dashaoao.core.di.network

import com.dashaoao.core.di.app.First
import com.dashaoao.core.di.app.Second
import com.dashaoao.core.domain.HomeDeps
import com.dashaoao.core.data.HomeDepsFirstImpl
import com.dashaoao.core.data.HomeDepsSecondImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NetworkModule {
    @[Binds Singleton First]
    fun bindRetrofitFirst(
        firstImpl: HomeDepsFirstImpl
    ): HomeDeps

    @[Binds Singleton Second]
    fun bindRetrofitSecond(
        secondImpl: HomeDepsSecondImpl
    ): HomeDeps
}
