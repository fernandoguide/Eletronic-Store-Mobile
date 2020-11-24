package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ConfirmacaoCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacao_compra)
    }

    fun irParaMenu(componente: View){
        val menu = Intent(applicationContext, Main::class.java)
        startActivity(menu)
    }
}