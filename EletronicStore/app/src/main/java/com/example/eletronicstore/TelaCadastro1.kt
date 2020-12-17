package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tela_cadastro1.*

class TelaCadastro1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro1)

    }

    fun irCadastro2(componente: View) {

        val caixamsg = et_email.text.toString()
        val name = et_nome.text.toString()
        val cpf = et_cpf.text.toString()
        val telefone = et_telefone.text.toString()

        val cadastro2 = Intent(this, TelaCadastro2::class.java)

        cadastro2.putExtra("email", caixamsg)
        cadastro2.putExtra("nome", name)
        cadastro2.putExtra("cpf", cpf)
        cadastro2.putExtra("telefone", telefone)

        startActivity(cadastro2)

    }

    fun irLogin(componente: View) {

        val login = Intent(this, Login::class.java)

        startActivity(login)
    }
}