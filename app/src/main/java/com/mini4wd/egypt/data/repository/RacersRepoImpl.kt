package com.mini4wd.egypt.data.repository

import com.mini4wd.egypt.data.datasource.RemoteDataSource
import com.mini4wd.egypt.data.model.Racer
import com.mini4wd.egypt.domain.RacerRepo
import javax.inject.Inject

class RacersRepoImpl @Inject constructor(private val remote: RemoteDataSource): RacerRepo {
  override suspend fun loadRacers(): List<Racer> {
   return remote.getRacers()
  }
}