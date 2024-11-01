package com.dashaoao.home.di

import com.dashaoao.core.di.First
import com.dashaoao.core.di.Second
import retrofit2.Retrofit
import javax.inject.Inject

class HomeDepsImpl @Inject constructor(
    @First private val retrofitFirst: Retrofit,
    @Second private val retrofitSecond: Retrofit
) : HomeDeps {
    override fun getRetrofitFirst(): Retrofit =
        retrofitFirst

    override fun getRetrofitSecond(): Retrofit =
        retrofitSecond
}
