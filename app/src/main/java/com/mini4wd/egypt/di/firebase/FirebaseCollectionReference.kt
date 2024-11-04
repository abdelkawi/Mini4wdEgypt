package com.mini4wd.egypt.di.firebase

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class FirebaseCollectionReference(val value: FirebaseCollections)