package com.jayguy.globalnews.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.jayguy.globalnews.ui.theme.GlobalGameTheme
import com.jayguy.globalnews.viewmodels.HomeViewModel

/**
 * Created by Leo on 2022/11/8.
 */

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        HomeScreen(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            gamesList = homeViewModel.gamesListState.collectAsLazyPagingItems(),
            onClickToDetailScreen = onClickToDetailScreen,
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeFragmentPreview() {
    GlobalGameTheme {
        HomeFragment()
    }
}