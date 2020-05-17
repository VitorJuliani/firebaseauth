package com.authentication.springandfirebaseauth.firebase

import com.authentication.springandfirebaseauth.app.AppProperties
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class FirebaseConfiguration {

    @Bean
    fun initializeFirebaseApp(app: AppProperties): FirebaseApp {
        val serviceAccount: FileInputStream = FileInputStream(app.firebase.credentials)

        val options: FirebaseOptions = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(app.firebase.databaseUrl)
                .build()

        return FirebaseApp.initializeApp(options)
    }

    @Bean
    fun initializeFirebaseAuth(firebaseApp: FirebaseApp): FirebaseAuth {
        return FirebaseAuth.getInstance(firebaseApp)
    }
}