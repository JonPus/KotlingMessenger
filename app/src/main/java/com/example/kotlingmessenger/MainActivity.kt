package com.example.kotlingmessenger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {

            val email = email_edittext_register.text.toString()
            val password = password_edittext_register.text.toString()

            Log.d("MainActivity", "Email is: " + email)
            Log.d("MainActivity", "Password is: $password")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    // else if successful
                    Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
                }
        }

        already_have_account_textView.setOnClickListener {
            Log.d("MainActivity", "Try to show main activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
