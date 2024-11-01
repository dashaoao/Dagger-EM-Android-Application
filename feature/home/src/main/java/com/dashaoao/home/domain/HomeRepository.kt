package com.dashaoao.home.domain

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getData(): Flow<String>
}
