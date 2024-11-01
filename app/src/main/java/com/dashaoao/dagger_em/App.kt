package com.dashaoao.dagger_em

import android.app.Application
import com.dashaoao.home.di.HomeDepsProvider
import com.dashaoao.dagger_em.di.DaggerAppComponent
import com.dashaoao.home.di.HomeDeps

class App : Application(),
    HomeDepsProvider {
    private val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun getHomeDeps(): HomeDeps {
        return appComponent.getHomeDeps()
    }
}
