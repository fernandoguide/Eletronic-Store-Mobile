package com.example.eletronicstore.services

import com.example.eletronicstore.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers( "Content-Type: application/json")
    @POST("login")
    fun userLogin(
        @Body body: User
    ):Call<ResponseBody>

    @Headers( "Content-Type: application/json")
    @POST("auth/forgot")
    fun esqueciSenha(
        @Body body: User
    ):Call<ResponseBody>
}