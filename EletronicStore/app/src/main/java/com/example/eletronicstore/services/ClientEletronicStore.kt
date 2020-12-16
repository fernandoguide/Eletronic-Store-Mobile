package com.example.eletronicstore.services

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClientEletronicStore {

    private const val BASE_URL_HEROKU = "https://eletronic-store.herokuapp.com/"

    private lateinit var apiService: LoginService

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }

    private val okHttpClient  = OkHttpClient.Builder()
        .callTimeout(2, TimeUnit.MINUTES)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()


    fun getApiService(context: Context): LoginService {

        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_HEROKU)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()

            apiService = retrofit.create(LoginService::class.java)
        }

        return apiService
    }

    val instance: LoginService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_HEROKU)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(LoginService::class.java)
    }

    val endpoint: CategoriaService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_HEROKU)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(CategoriaService::class.java)
    }
}