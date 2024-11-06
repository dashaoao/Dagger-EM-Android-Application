package com.dashaoao.core.data

import com.dashaoao.core.di.app.ApiUrlProvider
import com.dashaoao.core.domain.HomeDeps
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class HomeDepsFirstImpl @Inject constructor() : HomeDeps {
    override fun getRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(getApiUrlProvider().url)
        .client(getHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getApiUrlProvider(): ApiUrlProvider = ApiUrlProvider.ApiUrlProviderImpl()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun getHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .build()
}
