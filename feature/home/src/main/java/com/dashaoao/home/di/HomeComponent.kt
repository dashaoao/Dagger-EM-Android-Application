package com.dashaoao.home.di

import com.dashaoao.core.di.AppDependencies
import com.dashaoao.home.presentation.HomeFragment
import dagger.Component

@Home
@Component(
    modules = [HomePresentationModule::class, HomeDataModule::class, HomeDomainModule::class],
    dependencies = [AppDependencies::class],
)
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appDependencies: AppDependencies
        ): HomeComponent
    }

    companion object {
        fun init(appDependencies: AppDependencies): HomeComponent {
            return DaggerHomeComponent.factory().create(appDependencies)
        }
    }

    fun inject(fragment: HomeFragment)
}
