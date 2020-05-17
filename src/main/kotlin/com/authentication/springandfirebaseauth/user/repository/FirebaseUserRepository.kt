package com.authentication.springandfirebaseauth.user.repository

import com.authentication.springandfirebaseauth.user.model.User
import com.authentication.springandfirebaseauth.user.model.UserRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.google.firebase.auth.UserRecord.CreateRequest
import com.google.firebase.auth.UserRecord.UpdateRequest

class FirebaseUserRepository(private val firebaseAuth: FirebaseAuth) : UserRepository {

    override fun saveNewUser(user: UserRequest): User {
        val createReq: CreateRequest = CreateRequest()
                .setEmail(user.email)
                .setPassword(user.password)
                .setDisplayName(user.displayName)
                .setDisabled(false)
                .setEmailVerified(false)

        val savedUser: UserRecord = firebaseAuth.createUser(createReq)

        return buildUserModel(savedUser)
    }

    override fun getUserByUid(id: String): User {
        val user: UserRecord = firebaseAuth.getUser(id)

        return buildUserModel(user)
    }

    override fun getUserByEmail(email: String): User {
        val user: UserRecord = firebaseAuth.getUserByEmail(email)

        return buildUserModel(user)
    }

    override fun updateUser(id: String, user: UserRequest): User {
        val updateReq: UpdateRequest = UpdateRequest(id)
                .setEmail(user.email)
                .setPassword(user.password)
                .setDisplayName(user.displayName)
                .setDisabled(false)
                .setEmailVerified(true)

        val updatedUser: UserRecord = firebaseAuth.updateUser(updateReq)

        return buildUserModel(updatedUser)
    }

    override fun deleteUser(id: String) {
        return firebaseAuth.deleteUser(id)
    }

    private fun buildUserModel(user: UserRecord): User {
        return User(user)
    }
}