package com.jayguy.globalnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jayguy.globalnews.domain.model.Games
import com.jayguy.globalnews.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Leo on 2022/11/8.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    gamesRepository: Repository,
): ViewModel() {

    val gamesListState: Flow<PagingData<Games>> =
        gamesRepository.getAllGames().cachedIn(viewModelScope)
}