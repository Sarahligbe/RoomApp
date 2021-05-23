package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomapp.database.UserRepository
import com.example.roomapp.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter email or password", Toast.LENGTH_LONG).show()
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    val repository = UserRepository(this@LoginActivity)
                    val user = repository.getUser(email, password)
                    if (user == null) {
                        Toast.makeText(
                            this@LoginActivity,
                            "User not found, enter a valid email or password",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val intent = Intent(this@LoginActivity, CategoryActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    }
                }
            }


        }
    }
}