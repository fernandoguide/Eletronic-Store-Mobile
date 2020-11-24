package com.example.eletronicstore.model

class Reset {

    var email: String? = null

    constructor() : super(){}

    constructor(email: String) : super(){
        this.email = email
    }
}