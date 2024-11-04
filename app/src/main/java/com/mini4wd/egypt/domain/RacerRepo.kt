package com.mini4wd.egypt.domain

import com.mini4wd.egypt.data.model.Racer

interface RacerRepo {
  suspend fun loadRacers(): List<Racer>
  suspend fun addRacer(racer: Racer):Boolean
}