package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoregister:TextView
    lateinit var Edt_email:EditText
    lateinit var Edt_password:EditText
    lateinit var Btn_login:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoregister = findViewById(R.id.TvLogin)
        Edt_email = findViewById(R.id.EdtLO_gmail)
        Edt_password = findViewById(R.id.Edtlogpass)
        Btn_login = findViewById(R.id.btn_login)
        auth = Firebase.auth

        Txt_gotoregister.setOnClickListener {
            var intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        Btn_login.setOnClickListener {
            login()
        }
    }
        private fun login(){
            val email=Edt_email.text.toString()
            val pass=Edt_password.text.toString()
            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
                if (it.isSuccessful){
                    Toast.makeText(this,"Successfully Logged in",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Log in failed",Toast.LENGTH_LONG).show()
            }
          }
    }
}