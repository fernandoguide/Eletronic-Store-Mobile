package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaCadastro3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro3)
    }

    fun irCadastro4(componente: View) {

        val cadastro4 = Intent(this, Login::class.java)

        startActivity(cadastro4)
    }

    fun voltarCadastro2(componente: View) {

        val voltarCadastro2 = Intent(this, TelaCadastro2::class.java)

        startActivity(voltarCadastro2)
    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}