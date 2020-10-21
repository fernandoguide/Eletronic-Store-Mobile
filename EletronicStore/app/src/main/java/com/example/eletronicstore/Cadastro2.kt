package com.example.eletronicstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Cadastro2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irCadastro3(componente: View) {

        val cadastro3 = Intent(this, Cadastro3::class.java)

        startActivity(cadastro3)
    }

    fun voltarCadastro(componente: View) {

        val voltarCadastro = Intent(this, Cadastro::class.java)

        startActivity(voltarCadastro)
    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}