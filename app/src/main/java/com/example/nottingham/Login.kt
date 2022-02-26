package com.example.nottingham

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignup: Button

    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        fAuth= FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edt_email)
        edtPass = findViewById(R.id.edt_pass)
        btnLogin = findViewById(R.id.btn_login)
        btnSignup = findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()

            login(email,pass)
        }

    }

    private fun login(email: String, pass: String){


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
        fAuth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Login,"Authentication Error", Toast.LENGTH_SHORT).show()
                }
            }
    }

}