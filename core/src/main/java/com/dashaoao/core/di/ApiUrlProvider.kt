package com.dashaoao.core.di

interface ApiUrlProvider {
    var url: String

    class ApiUrlProviderImpl : ApiUrlProvider {
        override var url: String = "https://tinkoff-android-spring.zulipchat.com/api/v1/"
    }
}
