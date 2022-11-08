package com.jayguy.globalnews.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jayguy.globalnews.domain.Service
import com.jayguy.globalnews.domain.model.Games
import com.jayguy.globalnews.utils.ApiResponseType
import com.jayguy.globalnews.utils.PagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Leo on 2022/11/8.
 */

@Singleton
class RepositoryImpl @Inject constructor(
    private val gamesService: Service,
    private val pageSize: Int,
    private val apiKey: String,
): Repository {
    override fun getAllGames(): Flow<PagingData<Games>> = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PagingSource(
                response = { pageNext ->
                    gamesService.getAllGames(
                        key = apiKey,
                        page = pageNext,
                        pageSize = pageSize,
                    )
                }
            )
        }
    ).flow

    override fun getDetailGames(id: Int): Flow<ApiResponseType<Games>> = flow<ApiResponseType<Games>>{
        try {
            emit(ApiResponseType.Loading)
            val responseApi = gamesService.getGamesDetail(
                key = apiKey,
                id = id
            )
            emit(ApiResponseType.Success(responseApi))
        } catch (e: Exception) {
            emit(ApiResponseType.Failure(e))
        }
    }.flowOn(Dispatchers.IO)
}