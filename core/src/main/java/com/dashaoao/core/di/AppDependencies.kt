package com.dashaoao.core.di

import com.dashaoao.core.di.app.AppContextProvider
import com.dashaoao.core.di.network.NetworkProvider


interface AppDependencies : AppContextProvider, NetworkProvider
