package com.example.a21411047tugasuas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a21411047tugasuas.databinding.ActivityForgetPasswordBinding
import com.example.a21411047tugasuas.databinding.ActivityRegisterBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icKembali.setOnClickListener {
            val intentLogin =  Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
        }

        binding.tvKembali.setOnClickListener {
            val intentLogin =  Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
        }
    }
}