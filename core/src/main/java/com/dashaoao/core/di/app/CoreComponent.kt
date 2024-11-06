package com.dashaoao.core.di.app

import android.app.Application
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component(modules = [AppDependenciesModule::class])
interface CoreComponent : AppContextProvider {

    companion object {
        fun init(app: Application): AppContextProvider {
            return DaggerCoreComponent
                .builder()
                .appDependenciesModule(AppDependenciesModule(app))
                .build()
        }
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class First

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Second
