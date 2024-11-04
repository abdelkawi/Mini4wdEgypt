package com.mini4wd.egypt.di.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mini4wd.egypt.data.datasource.RemoteDataSource
import com.mini4wd.egypt.data.repository.CarRepoImpl
import com.mini4wd.egypt.data.repository.RaceRepoImpl
import com.mini4wd.egypt.data.repository.RacersRepoImpl
import com.mini4wd.egypt.data.repository.RoundRepoImpl
import com.mini4wd.egypt.domain.CarRepo
import com.mini4wd.egypt.domain.RaceRepo
import com.mini4wd.egypt.domain.RacerRepo
import com.mini4wd.egypt.domain.RoundRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RaceModule {
  @Provides
  @Singleton
  @FirebaseCollectionReference(FirebaseCollections.RACES)
  fun provideRaceCollectionReference(): CollectionReference {
    return FirebaseFirestore.getInstance().collection(FirebaseCollections.RACES.collectionName)
  }
  @Provides
  @Singleton
  fun provideRaceRepoImpl():RaceRepo {
    return RaceRepoImpl()
  }
}
@Module
@InstallIn(SingletonComponent::class)
object RacersModule {
  @Provides
  @Singleton
  @FirebaseCollectionReference(FirebaseCollections.RACERS)
  fun provideRacersCollectionReference(): CollectionReference {
    return FirebaseFirestore.getInstance().collection(FirebaseCollections.RACERS.collectionName)
  }
  @Provides
  @Singleton
  fun provideRacersRepoImpl(remoteDataSource: RemoteDataSource): RacerRepo {
    return RacersRepoImpl(remoteDataSource)
  }
}

@Module
@InstallIn(SingletonComponent::class)
object CarsModule {
  @Provides
  @Singleton
  @FirebaseCollectionReference(FirebaseCollections.CARS)
  fun provideCarsCollectionReference(): CollectionReference {
    return FirebaseFirestore.getInstance().collection(FirebaseCollections.CARS.collectionName)
  }
  @Provides
  @Singleton
  fun provideCarRepoImpl(): CarRepo {
    return CarRepoImpl()
  }
}

@Module
@InstallIn(SingletonComponent::class)
object RoundModule {
  @Provides
  @Singleton
  @FirebaseCollectionReference(FirebaseCollections.ROUNDS)
  fun provideRoundCollectionReference(): CollectionReference {
    return FirebaseFirestore.getInstance().collection(FirebaseCollections.ROUNDS.collectionName)
  }
  @Provides
  @Singleton
  fun provideRoundRepoImpl(): RoundRepo {
    return RoundRepoImpl()
  }
}

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

  @Provides
  @Singleton
  fun firestore(): FirebaseFirestore{
    return Firebase.firestore
  }
}




enum class FirebaseCollections(val collectionName: String) {
  RACES("race"),
  RACERS("racers"),
  CARS("cars"),
  ROUNDS("round")
}