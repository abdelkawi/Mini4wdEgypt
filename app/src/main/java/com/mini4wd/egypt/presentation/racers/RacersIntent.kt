package com.mini4wd.egypt.presentation.racers

import com.mini4wd.egypt.data.model.Racer

sealed class RacersIntent {
  data object LoadRacers:RacersIntent()
  data class SearchRacer(val name:String):RacersIntent()
  data object Idle:RacersIntent()
  data object Empty:RacersIntent()
  data object ClearSearch:RacersIntent()
}