package com.mini4wd.egypt.di

import com.google.firebase.firestore.CollectionReference
import com.mini4wd.egypt.di.firebase.FirebaseCollectionReference
import com.mini4wd.egypt.di.firebase.FirebaseCollections


interface AppComponent {
  @FirebaseCollectionReference(FirebaseCollections.RACES)
  fun provideRacesCollectionReference() : CollectionReference

  @FirebaseCollectionReference(FirebaseCollections.RACERS)
  fun provideRacersCollectionReference() : CollectionReference

  @FirebaseCollectionReference(FirebaseCollections.CARS)
  fun provideCarsCollectionReference() : CollectionReference

  @FirebaseCollectionReference(FirebaseCollections.ROUNDS)
  fun provideRoundCollectionReference() : CollectionReference


}