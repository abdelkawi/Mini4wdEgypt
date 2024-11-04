package com.mini4wd.egypt.presentation.racers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mini4wd.egypt.domain.RacerRepo
import com.mini4wd.egypt.presentation.racers.RacersIntent.ClearSearch
import com.mini4wd.egypt.presentation.racers.RacersIntent.Empty
import com.mini4wd.egypt.presentation.racers.RacersIntent.Idle
import com.mini4wd.egypt.presentation.racers.RacersIntent.LoadRacers
import com.mini4wd.egypt.presentation.racers.RacersIntent.SearchRacer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RacersViewModel @Inject constructor(val repo: RacerRepo):ViewModel(){
  val userIntent = Channel<RacersIntent>(Channel.UNLIMITED)

  private val _state = MutableStateFlow<RacersState>(RacersState.Idle)
  val state: StateFlow<RacersState>
    get() = _state

  init {
    handleIntent()
  }
  private fun handleIntent(){
    viewModelScope.launch {
      userIntent.consumeAsFlow().collect {
        when (it) {
          ClearSearch -> {
            _state.value = RacersState.Clear
          }
          Empty -> {
            _state.value =RacersState.Empty
          }
          Idle -> {
            _state.value = RacersState.Idle
          }
          LoadRacers -> {
            loadRacers()
          }
          is SearchRacer -> {
          }
        }
      }
    }
  }
  private fun loadRacers() {
    _state.value = RacersState.Loading
   val racers = repo.loadRacers()
    _state.value = RacersState.RacersLoaded(racers)
  }
}