package com.authentication.springandfirebaseauth.app

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("app")
data class AppProperties(
        val firebase: Firebase
) {
    data class Firebase(
            val credentials: String,
            val databaseUrl: String
    )
}