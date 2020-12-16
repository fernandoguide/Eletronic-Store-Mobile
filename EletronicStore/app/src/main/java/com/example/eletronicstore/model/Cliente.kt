package com.example.eletronicstore.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Cliente(

    @JsonProperty("email")
    val email: String? = null,

    @JsonProperty("nome")
    val nome: String? = null,

    @JsonProperty("cpfOuCnpj")
    val cpfOuCnpj: String? = null,

    @JsonProperty("telefone1")
    val telefone1: String? = null,

    @JsonProperty("senha")
    val senha: String? = null,

    @JsonProperty("cep")
    val cep: String? = null,

    @JsonProperty("bairro")
    val bairro: String? = null,

    @JsonProperty("logradouro")
    val logradouro: String? = null,

    @JsonProperty("numero")
    val numero: String? = null,

    @JsonProperty("cidadeId")
    val cidadeId: Int? = 2,

    @JsonProperty("tipo")
    val tipo: Int? = 1
)