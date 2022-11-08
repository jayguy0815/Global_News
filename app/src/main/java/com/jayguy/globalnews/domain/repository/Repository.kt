package com.jayguy.globalnews.domain.repository

import androidx.paging.PagingData
import com.jayguy.globalnews.domain.model.Games
import com.jayguy.globalnews.utils.ApiResponseType
import kotlinx.coroutines.flow.Flow

/**
 * Created by Leo on 2022/11/8.
 */

interface Repository {
    fun getAllGames(): Flow<PagingData<Games>>
    fun getDetailGames(id: Int): Flow<ApiResponseType<Games>>
}