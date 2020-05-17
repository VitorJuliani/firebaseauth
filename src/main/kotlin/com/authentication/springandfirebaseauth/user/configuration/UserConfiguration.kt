package com.authentication.springandfirebaseauth.user.configuration

import com.authentication.springandfirebaseauth.user.repository.UserRepository
import com.authentication.springandfirebaseauth.user.repository.FirebaseUserRepository
import com.authentication.springandfirebaseauth.user.service.UserService
import com.authentication.springandfirebaseauth.user.service.UserServiceImpl
import com.google.firebase.auth.FirebaseAuth
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserConfiguration {

    @Bean
    fun userRepository(firebaseAuth: FirebaseAuth): UserRepository {
        return FirebaseUserRepository(firebaseAuth)
    }

    @Bean
    fun userService(userRepository: UserRepository): UserService {
        return UserServiceImpl(userRepository)
    }
}