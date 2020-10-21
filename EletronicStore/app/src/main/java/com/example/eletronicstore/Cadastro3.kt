package com.example.eletronicstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Cadastro3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irCadastro4(componente: View) {

        val cadastro4 = Intent(this, Cadastro4::class.java)

        startActivity(cadastro4)
    }

    fun voltarCadastro2(componente: View) {

        val voltarCadastro2 = Intent(this, Cadastro2::class.java)

        startActivity(voltarCadastro2)
    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}