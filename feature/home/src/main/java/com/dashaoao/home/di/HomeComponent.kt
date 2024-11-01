package com.dashaoao.home.di

import android.content.Context
import com.dashaoao.home.presentation.HomeFragment
import dagger.Component

@Home
@Component(
    modules = [HomePresentationModule::class, HomeDataModule::class, HomeDomainModule::class],
    dependencies = [HomeDeps::class]
)
interface HomeComponent {

    val deps: HomeDeps

    @Component.Factory
    interface Factory {
        fun create(
            homeDependencies: HomeDeps
        ): HomeComponent
    }

    companion object {
        @Volatile
        private var homeComponent: HomeComponent? = null

        @Synchronized
        fun init(context: Context): HomeComponent {
            if (homeComponent == null) {
                val deps = context as HomeDepsProvider
                homeComponent = DaggerHomeComponent.factory()
                    .create(deps.getHomeDeps())
            }
            return homeComponent!!
        }
    }

    fun inject(fragment: HomeFragment)
}
