package com.mini4wd.egypt.data.datasource

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.mini4wd.egypt.data.model.Racer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val db: FirebaseFirestore) {

 suspend fun getRacers(): List<Racer>{
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
      }.await()
   return racers
  }

  suspend fun addRacer(racer:Racer):Boolean {
    var done = false
    db.collection("racers").add(racer).addOnSuccessListener {
      done = true
    }.await()
    return done
  }
}