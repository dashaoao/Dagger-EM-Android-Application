package com.dashaoao.dagger_em.di

import com.dashaoao.core.di.app.AppContextProvider
import com.dashaoao.core.di.AppDependencies
import com.dashaoao.core.di.app.CoreComponent
import com.dashaoao.core.di.network.NetworkComponent
import com.dashaoao.core.di.network.NetworkProvider
import com.dashaoao.dagger_em.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppContextProvider::class, NetworkProvider::class]
)
interface AppComponent : AppDependencies {

    companion object {
        fun init(app: App): AppDependencies {
            return DaggerAppComponent
                .factory()
                .create(
                    CoreComponent.init(app),
                    NetworkComponent.init()
                )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            appContextProvider: AppContextProvider,
            networkProvider: NetworkProvider
        ): AppComponent
    }
}
