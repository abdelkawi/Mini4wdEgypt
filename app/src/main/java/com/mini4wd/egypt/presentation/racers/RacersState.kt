package com.mini4wd.egypt.presentation.racers

import com.mini4wd.egypt.data.model.Racer

sealed class RacersState {
  data class RacersLoaded(val racers: List<Racer>) : RacersState()
  data object Loading : RacersState()
  data class Error(val message: String) : RacersState()
  data object Idle : RacersState()
  data object Clear : RacersState()
  data object Empty : RacersState()
}