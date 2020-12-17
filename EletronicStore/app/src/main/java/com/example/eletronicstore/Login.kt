package com.example.eletronicstore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.eletronicstore.model.User
import com.example.eletronicstore.services.ClientEletronicStore
import com.example.eletronicstore.storage.SessionManager
import com.example.eletronicstore.storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class Login : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        btn_login.setOnClickListener {
            val email = email.text.toString().trim()
            val password = senha.text.toString().trim()
            val user = User(email, password)

            ClientEletronicStore.instance.userLogin(user)
                .enqueue(
                    object : Callback<ResponseBody> {
                        @SuppressLint("ShowToast")
                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            val headers: Headers = response.headers()
                            val auth = response.headers()["Authorization"]

                            if (response.isSuccessful) {

                                if (auth != null) {
                                    sessionManager.saveAuthToken(auth)
                                }
                                Toast.makeText(applicationContext, "Login realizado com sucesso", Toast.LENGTH_LONG).show()
                                val intent = Intent(applicationContext, Main::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            } else {
                                Toast.makeText(applicationContext, "Falha ao efetuar o login", Toast.LENGTH_LONG)
                                    .show()
                            }

                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            Toast.makeText(applicationContext, "Erro ao Conectar verifique se a internet esta ligada " + t.message , Toast.LENGTH_LONG).show()
                        }
                    }
                )
        }
    }

    override fun onStart() {
        super.onStart()

        if (SharedPrefManager.getInstance(this).isLoggedIn) {
            val intent = Intent(applicationContext, Main::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }

    fun irCadastro(componente: View) {

        val cadastro = Intent(this, TelaCadastro1::class.java)

        startActivity(cadastro)
    }

    fun irRecuperarSenha(Componente: View) {
        val recuperarSenha = Intent(this, TelaRecuperarSenha::class.java)

        startActivity(recuperarSenha)
    }
}