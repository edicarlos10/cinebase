package com.example.cinebase.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.cinebase.base.State
import com.example.domain.cinebase.home.model.NowPlaying
import com.example.domain.cinebase.home.model.Search
import com.example.domain.cinebase.home.usecase.GetCineMovieSearchUseCase
import com.example.domain.cinebase.home.usecase.GetCineNowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCineNowPlayingUseCase: GetCineNowPlayingUseCase,
    private val getCineMovieSearchUseCase: GetCineMovieSearchUseCase
): ViewModel() {

    private  val _nowPlayingState = MutableStateFlow<State<NowPlaying>>(State.loading())
    val nowPlaying = _nowPlayingState.asStateFlow()
//        get() = _nowPlayingState.asStateFlow()

//    init {
//        getNowPlaying()
//    }

    private  val _searchState = MutableStateFlow<State<Search>>(State.loading())
    val search = _searchState.asStateFlow()

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

    fun getMovieSearch(query: String, page: Int? = 1, language: String? = "pt-br"){
        viewModelScope.launch {
            getCineMovieSearchUseCase.execute(query, page, language).onStart {
                _searchState.emit(State.Loading)
            }.catch {
                _searchState.emit(State.Error(cause = it))
            }.collect{
                _searchState.emit(State.Data(it))
            }
        }
    }

    suspend fun setStateToIdle(){
        _nowPlayingState.emit(State.Idle)
    }
}