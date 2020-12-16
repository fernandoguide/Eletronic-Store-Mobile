package com.example.eletronicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class TelaPagamentoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //frete
    private var spinner_frete:Spinner ? = null
    private var arrayAdapter_frete:ArrayAdapter<String> ? = null
    private var itemList_frete = arrayOf("Sedex", "Braspress", "TNT")

    //pagamento
    private var spinner_pgto:Spinner ? = null
    private var arrayAdapter_pgto:ArrayAdapter<String> ? = null
    private var itemList_pgto = arrayOf("Cartão Crédito", "Cartão débito", "Boleto")


    private var spinner_end:Spinner ? = null
    private var arrayAdapter_end:ArrayAdapter<String> ? = null
    private var itemList_end = arrayOf("Rua Jose Floriano 100, Jd Guarani", "Rua do fundo 132, Centro", "Avenida Abacate 20, Vila Velha")



    fun carregarEndereco(){
        spinner_end = findViewById(R.id.combo_endereco)
        arrayAdapter_end = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item
            , itemList_end)

        spinner_end?.adapter = arrayAdapter_pgto
    }



    fun carregarCombo(){
        spinner_pgto = findViewById(R.id.combo_formaPagamento)
        arrayAdapter_pgto = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item
            , itemList_pgto)

        spinner_pgto?.adapter = arrayAdapter_pgto
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pagamento)

        spinner_frete = findViewById(R.id.combo_frete)
        arrayAdapter_frete = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item
        , itemList_frete)

        spinner_frete?.adapter = arrayAdapter_frete

        carregarCombo()

        carregarEndereco()
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nenhum Selecionado", Toast.LENGTH_LONG).show()
    }


    fun irConfirmacao(componente:View){
        val confirm = Intent(applicationContext, ConfirmacaoCompraActivity::class.java)
        startActivity(confirm)
    }

}