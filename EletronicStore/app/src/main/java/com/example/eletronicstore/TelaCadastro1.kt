package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaCadastro1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro1)
    }

    fun irCadastro2(componente: View) {

        val cadastro2 = Intent(this, TelaCadastro2::class.java)

        startActivity(cadastro2)

    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}