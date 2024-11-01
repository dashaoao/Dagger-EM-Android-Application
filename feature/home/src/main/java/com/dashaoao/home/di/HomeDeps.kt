package com.dashaoao.home.di

import retrofit2.Retrofit

interface HomeDeps {
    fun getRetrofitFirst(): Retrofit
    fun getRetrofitSecond(): Retrofit
}
