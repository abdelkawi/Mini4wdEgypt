package com.mini4wd.egypt.data.model

data class Race (
  val id:String,
  val date:String,
  val winner:String,
  val second:String,
  val third:String,
  val racers:List<Racer>
)