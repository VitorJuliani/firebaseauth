package com.authentication.springandfirebaseauth.user.service

import com.authentication.springandfirebaseauth.user.model.User
import com.authentication.springandfirebaseauth.user.model.UserRequest
import com.authentication.springandfirebaseauth.user.repository.UserRepository

class UserServiceImpl(private val repository: UserRepository): UserService {

    override fun saveNewUser(user: UserRequest): User {
        return repository.saveNewUser(user)
    }

    override fun getUserByUid(id: String): User {
        return repository.getUserByUid(id)
    }

    override fun getUserByEmail(email: String): User {
        return repository.getUserByEmail(email)
    }

    override fun updateUser(id: String, user: UserRequest): User {
        return repository.updateUser(id, user)
    }

    override fun deleteUser(id: String) {
        return repository.deleteUser(id)
    }

}