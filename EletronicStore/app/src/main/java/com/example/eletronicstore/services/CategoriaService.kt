package com.example.eletronicstore.services


import com.example.eletronicstore.model.Categoria
import retrofit2.Call
import retrofit2.http.*

interface CategoriaService {


        @Headers( "Content-Type: application/json")
        @GET("categorias")
        fun categorias(@Header("Authorization")token: Any?): Call<List<Categoria>>

}