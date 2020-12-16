package com.example.eletronicstore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.eletronicstore.model.Cliente
import com.example.eletronicstore.services.ClientEletronicStore
import com.example.eletronicstore.storage.SessionManager
import kotlinx.android.synthetic.main.activity_tela_cadastro3.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaCadastro3 : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro3)

        sessionManager = SessionManager(this)

        val email = intent.getStringExtra("email")
        val nome = intent.getStringExtra("nome")
        val cpfOuCnpj = intent.getStringExtra("cpf")
        val telefone1 = intent.getStringExtra("telefone")
        val senha = intent.getStringExtra("pasword")

        btn_finalizar.setOnClickListener {
            val cep = et_cep.text.toString()
            val bairro = et_bairro.text.toString()
            val logradouro = et_logradouro.text.toString()
            val numero = et_numero.text.toString()
            val cliente =
                Cliente(email, nome, cpfOuCnpj, telefone1, senha, cep, bairro, logradouro, numero)

            ClientEletronicStore.instance.createUser(cliente)
                .enqueue(
                    object : Callback<ResponseBody> {
                        @SuppressLint("ShowToast")
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {

                            Log.d("Cadastro", cliente.toString())
                            Log.d("Body", response.body().toString())

                            if (response.isSuccessful) {
                                Toast.makeText(
                                    applicationContext,
                                    "Cadastrado com sucesso ",
                                    Toast.LENGTH_LONG
                                ).show()
                                /*    val intent = Intent(applicationContext, TelaCadastro4::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    startActivity(intent) */
                            } else {

                                Log.d("Body", response.errorBody().toString())

                                Toast.makeText(
                                    applicationContext,
                                    "Falha ao cadastrar",
                                    Toast.LENGTH_LONG

                                )
                                    .show()
                            }

                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            Toast.makeText(
                                applicationContext,
                                "Erro ao Conectar verifique se a internet esta ligada " + t.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                )
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
}