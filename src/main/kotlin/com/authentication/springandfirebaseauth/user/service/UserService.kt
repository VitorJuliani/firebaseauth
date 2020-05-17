package com.authentication.springandfirebaseauth.user.service

import com.authentication.springandfirebaseauth.user.model.User
import com.authentication.springandfirebaseauth.user.model.UserRequest

interface UserService {

    fun saveNewUser(user: UserRequest): User

    fun getUserByUid(id: String): User

    fun getUserByEmail(email: String): User

    fun updateUser(id: String, user: UserRequest): User

    fun deleteUser(id: String)
}