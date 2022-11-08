package com.jayguy.globalnews.utils

import com.jayguy.globalnews.utils.Injection.DETAIL_ARG_GAMES_ID
import com.jayguy.globalnews.utils.Injection.DETAIL_SCREEN
import com.jayguy.globalnews.utils.Injection.HOME_SCREEN

/**
 * Created by Leo on 2022/11/8.
 */

sealed class Route(val route: String) {
    object Home: Route(HOME_SCREEN)
    object Detail: Route("$DETAIL_SCREEN/{$DETAIL_ARG_GAMES_ID}") {
        fun createRoute(gamesId: Int) = "$DETAIL_SCREEN/$gamesId"
    }
}