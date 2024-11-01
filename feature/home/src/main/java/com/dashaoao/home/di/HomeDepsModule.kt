package com.dashaoao.home.di

import com.dashaoao.core.di.First
import com.dashaoao.core.di.Second
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeDepsModule {
    @Provides
    fun provideHomeDeps(
        @First retrofitFirst: Retrofit,
        @Second retrofitSecond: Retrofit
    ): HomeDeps {
        return HomeDepsImpl(retrofitFirst, retrofitSecond)
    }
}
