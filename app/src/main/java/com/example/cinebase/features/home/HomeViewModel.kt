package com.example.cinebase.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.cinebase.base.State
import com.example.domain.cinebase.nowplaying.model.NowPlaying
import com.example.domain.cinebase.nowplaying.usecase.GetCineNowPlayingUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getCineNowPlayingUseCase: GetCineNowPlayingUseCase
): ViewModel() {

    private  val _nowPlayingState = MutableStateFlow<State<List<NowPlaying>>>(State.loading())
    val nowPlaying: Flow<State<List<NowPlaying?>>>
        get() = _nowPlayingState

//    init {
//        getNowPlaying()
//    }

    fun getNowPlaying(page: Int? = 1, language: String? = "pt-br"){
        viewModelScope.launch {
            getCineNowPlayingUseCase.execute(page, language).onStart {
                _nowPlayingState.emit(State.Loading)
            }.catch {
                _nowPlayingState.emit(State.Error(cause = it))
            }.collect{
                _nowPlayingState.emit(State.Data(it))
            }
        }
    }
}