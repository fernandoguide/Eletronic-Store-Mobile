package com.example.eletronicstore.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.eletronicstore.R

class SessionManager (context: Context){

    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val TOKEN = "Authorization"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(TOKEN, null)
    }

}