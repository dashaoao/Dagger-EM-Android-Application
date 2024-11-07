package com.dashaoao.core.di.network

import com.dashaoao.core.di.app.First
import com.dashaoao.core.di.app.Second
import com.dashaoao.core.domain.HomeDeps

interface NetworkProvider {

    @First
    fun provideFirstRetrofit(): HomeDeps

    @Second
    fun provideSecondRetrofit(): HomeDeps
}
