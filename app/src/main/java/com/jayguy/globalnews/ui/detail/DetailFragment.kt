package com.jayguy.globalnews.ui.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jayguy.globalnews.R
import com.jayguy.globalnews.ui.theme.GlobalGameTheme
import com.jayguy.globalnews.ui.views.ErrorButton
import com.jayguy.globalnews.ui.views.LoadingCircular
import com.jayguy.globalnews.utils.ApiResponseType
import com.jayguy.globalnews.viewmodels.DetailViewModel

/**
 * Created by Leo on 2022/11/8.
 */

@Composable
fun DetailFragment(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
    id: Int = -1,
) {
    fun launch() {
        detailViewModel.getDetailGames(id)
    }

    launch()
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(val gamesResponse = detailViewModel.gamesState.value){
            is ApiResponseType.Loading -> {
                LoadingCircular(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            is ApiResponseType.Success -> {
                DetailScreen(
                    games = gamesResponse.data
                )
            }
            is ApiResponseType.Failure -> {
                ErrorButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.error_message),
                    onClick = {
                        launch()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailFragmentPreview() {
    GlobalGameTheme {
        DetailFragment()
    }
}