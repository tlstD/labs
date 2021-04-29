package com.example.kalkulator

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var sign_up:TextView? = null
        sign_up = findViewById(R.id.sign_up)
        var back:TextView? = null
        back = findViewById(R.id.back)
        val sign = Intent(this,LoginActivity::class.java)

        var email: EditText? = null
        email = findViewById(R.id.editTextTextEmailAddress2)
        var login: EditText? = null
        login = findViewById(R.id.editTextTextEmailAddress)
        var password: EditText? = null
        password = findViewById(R.id.editTextTextPassword)
        var password2: EditText? = null
        password2 = findViewById(R.id.editTextTextPassword2)
        var human:TextView? = null

        var log:String = ""
        var pas:String = ""
        var i = intent.getIntExtra("i", 0)
        var proverka:Int = 1








        sign_up.setOnClickListener{


            log = login.text.toString()
            pas = password.text.toString()
            i++
            sign.putExtra("log", log)
            sign.putExtra("pas", pas)
            sign.putExtra("i", i)
            sign.putExtra("proverka", proverka)
            startActivity(sign)


        }
        back.setOnClickListener{
            startActivity(sign)
        }


    }










}