package com.mini4wd.egypt.data.model

data class Round (
  val id:String,
  val car1:Car,
  val car2:Car,
  val car3:Car,
  val winner:RoundRacerResult,
  val second:RoundRacerResult,
  val third:RoundRacerResult,
  val race:Race
)