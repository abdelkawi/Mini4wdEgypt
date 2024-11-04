package com.mini4wd.egypt.domain

import com.mini4wd.egypt.data.model.Race

interface RaceRepo {
  fun addRace(race: Race)
}