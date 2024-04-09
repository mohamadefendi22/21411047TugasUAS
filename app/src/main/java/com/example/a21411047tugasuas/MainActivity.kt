package com.example.a21411047tugasuas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a21411047tugasuas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDaftar.setOnClickListener {
            val intentRegister =  Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

        binding.tvLupaKataSandi.setOnClickListener {
            val intentForgetPassword =  Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intentForgetPassword)
        }

        binding.btnMasuk.setOnClickListener {
            val intentHome =  Intent(this, HomeActivity::class.java)
            startActivity(intentHome)
        }
    }
}