package com.example.eletronicstore.model

class User{
    var email: String? = null
    var senha: String? = null

    constructor() : super(){}

    constructor(email: String, senha: String) : super(){
        this.email = email
        this.senha = senha
    }
}