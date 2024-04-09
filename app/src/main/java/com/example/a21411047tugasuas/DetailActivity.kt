package com.example.a21411047tugasuas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gambar : ImageView = findViewById(R.id.iv_gambar)
        val nama : TextView = findViewById(R.id.tv_nama)
        val berkuasa : TextView = findViewById(R.id.tv_berkuasa)
        val kesultanan : TextView = findViewById(R.id.tv_kesultanan)
        val biografi : TextView = findViewById(R.id.tv_biografi)

        val bundle: Bundle?= intent.extras
        val bNama = bundle!!.getString("idnama")
        val bGambar = bundle.getInt("idgambar")
        val bBerkuasa = bundle.getString("idberkuasa")
        val bKesultanan = bundle.getString("idkesultanan")
        val bBiografi = bundle.getString("idbiografi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        berkuasa.text = bBerkuasa
        kesultanan.text = bKesultanan
        biografi.text = bBiografi
    }
}