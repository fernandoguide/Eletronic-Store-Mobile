package com.example.eletronicstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class TelaPagamentoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private var spinner:Spinner ? = null
    private var arrayAdapter:ArrayAdapter<String> ? = null
    private var itemList = arrayOf("Sedex", "Braspress", "TNT")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pagamento)

        spinner = findViewById(R.id.combo_frete)
        arrayAdapter = ArrayAdapter(applicationContext , android.R.layout.simple_spinner_dropdown_item
        , itemList)

        spinner?.adapter = arrayAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nenhum Selecionado", Toast.LENGTH_LONG).show()
    }

}