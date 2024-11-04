package com.mini4wd.egypt.domain

import com.mini4wd.egypt.data.model.Car

interface CarRepo {
  fun addCar(car: Car)
  fun getCars():List<Car>
  fun deleteCar(car: Car)
  fun updateCar(car: Car)
}