package com.dashaoao.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CoreModule {

    @Provides
    @First
    @Core
    fun provideRetrofitFirst(): Retrofit {
        return getRetrofit()
    }

    @Provides
    @Second
    @Core
    fun provideRetrofitSecond(): Retrofit {
        return getRetrofit()
    }

    private fun getApiUrlProvider(): ApiUrlProvider = ApiUrlProvider.ApiUrlProviderImpl()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun getRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(getApiUrlProvider().url)
        .client(getHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

}
