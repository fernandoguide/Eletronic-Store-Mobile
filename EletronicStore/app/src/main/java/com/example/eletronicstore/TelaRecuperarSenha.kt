package com.example.eletronicstore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.eletronicstore.model.Reset
import com.example.eletronicstore.services.ClientEletronicStore
import com.example.eletronicstore.storage.SessionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tela_recuperar_senha.*
import kotlinx.android.synthetic.main.activity_tela_recuperar_senha.email
import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TelaRecuperarSenha : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_recuperar_senha)

        sessionManager = SessionManager(this)

        btn_recuperar.setOnClickListener {
            val email = email.text.toString().trim()
            val reset = Reset(email)

            ClientEletronicStore.instance.esqueciSenha(reset)
                .enqueue(
                    object : Callback<ResponseBody> {
                        @SuppressLint("ShowToast")
                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            val headers: Headers = response.headers()

                            if (response.isSuccessful) {
                                Toast.makeText(applicationContext, "Redefinição de senha enviada, por favor verifique seu email! ", Toast.LENGTH_LONG).show()
                                val login = Intent(applicationContext, Login::class.java)
                                login.flags =Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                                startActivity(login)
                            } else {
                                Toast.makeText(applicationContext, "Email não Cadastrado", Toast.LENGTH_LONG)
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



    fun voltarLogin(componente: View) {

        val voltarLogin = Intent(this, Login::class.java)

        startActivity(voltarLogin)
    }
}