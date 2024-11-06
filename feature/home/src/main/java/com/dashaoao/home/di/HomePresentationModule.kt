package com.dashaoao.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dashaoao.core.di.app.AppViewModelFactory
import com.dashaoao.home.presentation.HomeViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface HomePresentationModule {
    @[Binds Home]
    fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @[Binds IntoMap ViewModelKey(HomeViewModel::class) Home]
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
