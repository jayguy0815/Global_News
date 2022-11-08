package com.jayguy.globalnews.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayguy.globalnews.domain.model.Games
import com.jayguy.globalnews.domain.repository.Repository
import com.jayguy.globalnews.utils.ApiResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Leo on 2022/11/8.
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val gamesRepository: Repository,
): ViewModel() {
    private val _gamesState = mutableStateOf<ApiResponseType<Games>>(ApiResponseType.Success(null))
    val gamesState: State<ApiResponseType<Games>> = _gamesState

    fun getDetailGames(id: Int) {
        viewModelScope.launch {
            gamesRepository.getDetailGames(id).collect { response ->
                _gamesState.value = response
            }
        }
    }
}