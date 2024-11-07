package com.dashaoao.dagger_em

import android.app.Application
import com.dashaoao.core.di.AppDependencies
import com.dashaoao.core.di.AppDependenciesProvider
import com.dashaoao.dagger_em.di.AppComponent

class App : Application(),
    AppDependenciesProvider {
    private lateinit var appComponent: AppDependencies

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.init(this)
    }

    override fun provide(): AppDependencies {
        return appComponent
    }
}
