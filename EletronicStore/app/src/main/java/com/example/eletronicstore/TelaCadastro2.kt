package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tela_cadastro1.*
import kotlinx.android.synthetic.main.activity_tela_cadastro2.*

class TelaCadastro2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro2)
    }

    fun irCadastro3(componente: View) {

        val email = intent.getStringExtra("email")
        val nome = intent.getStringExtra("nome")
        val cpfOuCnpj = intent.getStringExtra("cpf")
        val telefone1 = intent.getStringExtra("telefone")
        val pasword = et_senha.text.toString()
        val senha2 = et_senha2.text.toString()

        val cadastro3 = Intent(this, TelaCadastro3::class.java)

        cadastro3.putExtra("email", email)
        cadastro3.putExtra("nome", nome)
        cadastro3.putExtra("cpf", cpfOuCnpj)
        cadastro3.putExtra("telefone", telefone1)
        cadastro3.putExtra("pasword", pasword)

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