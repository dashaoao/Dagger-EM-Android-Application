package com.dashaoao.core.di.app

interface ApiUrlProvider {
    var url: String

    class ApiUrlProviderImpl : ApiUrlProvider {
        override var url: String = "https://tinkoff-android-spring.zulipchat.com/api/v1/"
    }
}
