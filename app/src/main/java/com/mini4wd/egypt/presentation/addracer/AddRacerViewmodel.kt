package com.mini4wd.egypt.presentation.addracer

import androidx.lifecycle.ViewModel
import com.mini4wd.egypt.data.model.Racer
import com.mini4wd.egypt.domain.RacerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRacerViewmodel @Inject constructor(private  val racerRepository: RacerRepo): ViewModel(){
  suspend fun addRacer(racer: Racer):Boolean{
    return racerRepository.addRacer(racer)
  }
}