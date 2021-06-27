package com.example.challenge_registrationform

import java.io.Serializable

data class UserInfo(
    val level: String,
    val firstName: String,
    val lastName: String,
    val eMail: String,
    val phoneNumber: String,
    val password: String
) : Serializable