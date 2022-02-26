package com.example.nottingham

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnSignup: Button
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        fAuth= FirebaseAuth.getInstance()
        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPass = findViewById(R.id.edt_pass)
        btnSignup = findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()

            signup(email, pass)
        }
    }

    private fun signup(email:String,pass:String){

        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Email is required")
            return
        }
        if (TextUtils.isEmpty(pass)) {
            edtPass.setError("Password is required")
            return
        }
        if (pass.length < 6) {
            edtPass.setError("Password Character should be more than 6 ")
            return
        }

        fAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp,"Error Occurred",Toast.LENGTH_SHORT).show()

                }
            }
    }
}