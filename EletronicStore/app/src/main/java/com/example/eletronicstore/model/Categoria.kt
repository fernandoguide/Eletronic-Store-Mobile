package com.example.eletronicstore.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Categoria (
    @SerializedName("id")
    @JsonProperty("id")
    val id: Any? = null,

    @SerializedName("nome")
    @JsonProperty("nome")
    val nome: Any? = null
)