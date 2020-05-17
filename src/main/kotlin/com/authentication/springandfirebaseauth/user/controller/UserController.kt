package com.authentication.springandfirebaseauth.user.controller

import com.authentication.springandfirebaseauth.user.model.User
import com.authentication.springandfirebaseauth.user.model.UserRequest
import com.authentication.springandfirebaseauth.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @PostMapping
    fun saveNewUser(@RequestBody user: UserRequest): ResponseEntity<User> {
        val savedUser = service.saveNewUser(user)

        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/userById/${savedUser.uid}")
                .build()
                .toUri()

        return ResponseEntity.created(location).body(savedUser)
    }

    @GetMapping("/userById/{id}")
    fun getUserById(@PathVariable("id") id: String): ResponseEntity<User> {
        val user = service.getUserByUid(id)

        return ResponseEntity.ok(user)
    }

    @GetMapping("/userByEmail/{email}")
    fun getUserByEmail(@PathVariable("email") email: String): ResponseEntity<User> {
        val user = service.getUserByEmail(email)

        return ResponseEntity.ok(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String): ResponseEntity<Any> {
        service.deleteUser(id)

        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: String, @RequestBody user: UserRequest): ResponseEntity<User> {
        val updatedUser = service.updateUser(id, user)

        return ResponseEntity.ok(updatedUser)
    }
}