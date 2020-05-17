package com.authentication.springandfirebaseauth.user.repository

import com.authentication.springandfirebaseauth.user.model.User
import com.authentication.springandfirebaseauth.user.model.UserRequest

interface UserRepository {

    fun saveNewUser(user: UserRequest): User

    fun getUserByUid(id: String): User

    fun getUserByEmail(email: String): User

    fun updateUser(id: String, user: UserRequest): User

    fun deleteUser(id: String)
}