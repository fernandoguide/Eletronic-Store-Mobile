package com.example.eletronicstore.response

import com.example.eletronicstore.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    var status: Int,

    @SerializedName("Authorization")
    var authToken: String,

    @SerializedName("user")
    val user: User

)