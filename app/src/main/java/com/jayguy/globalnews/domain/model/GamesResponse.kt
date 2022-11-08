package com.jayguy.globalnews.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Leo on 2022/11/8.
 */

data class GamesResponse(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("previous")
    val previous: String? = null,

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("results")
    val results: List<Games> = listOf(),
)