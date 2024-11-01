package com.dashaoao.dagger_em.di

import android.content.Context
import com.dashaoao.core.di.First
import com.dashaoao.core.di.Second
import com.dashaoao.home.di.HomeDepsModule
import com.dashaoao.home.di.HomeDeps
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, HomeDepsModule::class]
)
interface AppComponent {
    @First
    fun getRetrofitFirst(): Retrofit

    @Second
    fun getRetrofitSecond(): Retrofit

    fun getHomeDeps(): HomeDeps

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}
