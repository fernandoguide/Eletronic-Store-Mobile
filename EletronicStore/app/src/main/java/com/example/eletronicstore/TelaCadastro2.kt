package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaCadastro2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro2)
    }

    fun irCadastro3(componente: View) {

        val cadastro3 = Intent(this, TelaCadastro3::class.java)

        startActivity(cadastro3)
    }

    fun voltarCadastro(componente: View) {

        val voltarCadastro = Intent(this, TelaCadastro1::class.java)

        startActivity(voltarCadastro)
    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}