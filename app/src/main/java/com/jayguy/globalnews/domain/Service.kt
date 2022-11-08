package com.jayguy.globalnews.domain

import com.jayguy.globalnews.domain.model.Games
import com.jayguy.globalnews.domain.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Leo on 2022/11/8.
 */

interface Service {

    @GET("games")
    suspend fun getAllGames(
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
    ) : GamesResponse

    @GET("games/{id}")
    suspend fun getGamesDetail(
        @Path("id") id: Int,
        @Query("key") key: String,
    ) : Games
}