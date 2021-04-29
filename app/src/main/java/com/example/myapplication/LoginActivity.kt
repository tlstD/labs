package com.example.kalkulator

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val log = Intent(this, MainActivity::class.java)
        var logi= intent.getStringExtra("log")
        var pas= intent.getStringExtra("pas")
        var proverka = intent.getIntExtra("proverka", 0)
        var savei = sharedPreferences.getInt("nomer",1)
        var i = intent.getIntExtra("i", savei)
        var mas = emptyArray<String>()
        mas+=logi.toString()
        mas+=pas.toString()





        var ar = emptyArray<String>()
        var chek = Array(1+i,{Array(2,{""})})
        chek[0] = arrayOf("1111","1112")
        if (i>1) {
            for (ii in 1..i) {
                chek[ii][0] = sharedPreferences.getString("login$ii", "").toString()
                chek[ii][1] = sharedPreferences.getString("password$ii", "").toString()
            }
        }
        if (proverka == 1) {
            chek[i] = mas
        }
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("login$i", chek[i][0])
        editor.putString("password$i", chek[i][1])
        editor.putInt("nomer", i)
        editor.apply()
        mas = emptyArray()
        var n:Int=0
        var tru:String =""
        var strLogin:String =""
        var strPassword:String = ""


        var login:EditText? = null
        login = findViewById(R.id.editTextTextEmailAddress)
        var password:EditText? = null
        password = findViewById(R.id.editTextTextPassword)
        var sign_up: TextView? = null
        sign_up = findViewById(R.id.sign_up)
        sign_up.setOnClickListener{
            strLogin = login.text.toString()
            strPassword = password.text.toString()
            if(strLogin.isNotEmpty()&&strPassword.isNotEmpty()) {
                ar += login.text.toString()
                ar += password.text.toString()
                n = 0
                while (n in 0..i) {
                    if (chek[n].contentEquals(ar)) {
                        startActivity(log)
                        ar = emptyArray()
                        tru = "true"
                        break
                    } else {
                        n++

                    }
                }
            }
            if (tru == "true") {
                Toast.makeText(this, "Успешная авторизация", Toast.LENGTH_SHORT).show()
                ar = emptyArray()
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                ar = emptyArray()
                login.setText("")
                password.setText("")
            }


        }
        val sign = Intent(this,RegisterActivity::class.java)
        var sign_in:TextView? = null
        sign_in = findViewById(R.id.sign_up2)
        sign_in.setOnClickListener{
            sign.putExtra("i", i)
            startActivity(sign)
        }
    }
}