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

class Registration : AppCompatActivity() {
    lateinit var Txt_register:TextView
    lateinit var Edt_email:EditText
    lateinit var Edt_password:EditText
    lateinit var Edt_conpassword:EditText
    lateinit var Btn_register:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        Txt_register=findViewById(R.id.TvRegister)
        Edt_email=findViewById(R.id.EdtRE_gmail)
        Edt_password=findViewById(R.id.EdtRegpass)
        Edt_conpassword=findViewById(R.id.EdtRegpass2)
        Btn_register=findViewById(R.id.btn_register)
        auth=Firebase.auth

        Txt_register.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        Btn_register.setOnClickListener {
            Signupuser()

        }
    }
    private fun Signupuser(){

        val email=Edt_email.text.toString()
        val pass=Edt_password.text.toString()
        val conpass=Edt_conpassword.text.toString()

        if (email.isBlank()||pass.isBlank()){
            Toast.makeText(this,"Please insert password and email",Toast.LENGTH_LONG).show()
            return
        }else if (pass != conpass){
            Toast.makeText(this,"Password do not match",Toast.LENGTH_LONG).show()

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }
        }

    }
}