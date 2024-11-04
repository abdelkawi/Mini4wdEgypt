package com.mini4wd.egypt.data.datasource

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.mini4wd.egypt.data.model.Racer
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val db: FirebaseFirestore) {

  fun getRacers():List<Racer>{
    val racers = mutableListOf<Racer>()
    db.collection("racers")
      .get()
      .addOnSuccessListener { documents ->
        for (document in documents) {
         racers.add(document.toObject(Racer::class.java))
        }
      }
      .addOnFailureListener { exception ->
        Log.w("FirebaseError", "Error getting documents: ", exception)
      }
    return racers
  }

  fun addRacer(racer:Racer):Boolean {
    var done = false
    db.collection("racers").add(racer).addOnSuccessListener {
      done = true
    }
    return done
  }
}