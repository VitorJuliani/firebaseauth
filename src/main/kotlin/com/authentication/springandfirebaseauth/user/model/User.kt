package com.authentication.springandfirebaseauth.user.model

import com.google.firebase.auth.UserRecord

data class User(
    val uid: String,
    val email: String,
    val emailVerified: Boolean,
    val displayName: String,
    val disabled: Boolean
) {
    constructor(user: UserRecord): this(user.uid, user.email, user.isEmailVerified, user.displayName, user.isDisabled)
}