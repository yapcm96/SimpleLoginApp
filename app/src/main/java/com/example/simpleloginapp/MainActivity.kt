package com.example.simpleloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById<EditText>(R.id.editUsername)
        var password = findViewById<EditText>(R.id.editPassword)
        var loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            if (username.text.isNullOrBlank() || password.text.isNullOrBlank()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            } else if (username.text.toString() != "testuser" || password.text.toString() != "1234") {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            } else {
                var message1 = username.text.toString()
                var message2 = password.text.toString()
                Toast.makeText(
                    this,
                    "Hello $message1! Your password is $message2",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }
    }
}