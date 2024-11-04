package com.mini4wd.egypt.domain

import com.mini4wd.egypt.data.model.Racer

interface RacerRepo {
  fun loadRacers(): List<Racer>
}