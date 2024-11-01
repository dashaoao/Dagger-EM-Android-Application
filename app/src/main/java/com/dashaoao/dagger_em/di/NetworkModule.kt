package com.dashaoao.dagger_em.di

import android.content.Context
import com.dashaoao.core.di.CoreComponent
import com.dashaoao.core.di.First
import com.dashaoao.core.di.Second
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @[Provides Singleton First]
    fun provideRetrofitFirst(context: Context): Retrofit {
        return CoreComponent.init(context).getFirstRetrofit()
    }
    @[Provides Singleton Second]
    fun provideRetrofitSecond(context: Context): Retrofit {
        return CoreComponent.init(context).getSecondRetrofit()
    }
}
