package com.example.a21411047tugasuas

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a21411047tugasuas.databinding.ActivityHomeBinding
import com.example.a21411047tugasuas.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var sultanRecyclerView: RecyclerView
    private lateinit var nama : Array<String>
    private lateinit var berkuasa : Array<String>
    private lateinit var kesultanan : Array<String>
    private lateinit var gambar : Array<Int>
    private lateinit var biografi : Array<String>
    private lateinit var listSultan : ArrayList<ItemData>

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            Intent(this@HomeActivity, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        gambar = arrayOf(
            R.drawable.osman1,
            R.drawable.orhan1ke2,
            R.drawable.murad1ke3,
            R.drawable.bayezid1ke4,
            R.drawable.mehmed1ke5,
            R.drawable.murad2ke6,
            R.drawable.mehmed2ke7,
            R.drawable.bayezid2ke8,
            R.drawable.selim1ke9,
            R.drawable.suleiman1ke10,
        )

        nama = arrayOf(
            "Osman I",
            "Orhan I",
            "Murad I",
            "Bayezid I",
            "Mehmed I",
            "Murad II",
            "Mehmed II",
            "Bayezid II",
            "Selim I",
            "Suleyman I"
        )

        kesultanan = arrayOf(
            "Sultan Pertama Kesultanan Utsmaniyah ",
            "Sultan ke 2 Kesultanan Utsmaniyah ",
            "Sultan ke 3 Kesultanan Utsmaniyah ",
            "Sultan ke 4 Kesultanan Utsmaniyah ",
            "Sultan ke 5 Kesultanan Utsmaniyah ",
            "Sultan ke 6 Kesultanan Utsmaniyah ",
            "Sultan ke 7 Kesultanan Utsmaniyah ",
            "Sultan ke 8 Kesultanan Utsmaniyah ",
            "Sultan ke 9 Kesultanan Utsmaniyah ",
            "Sultan ke 10 Kesultanan Utsmaniyah "
        )

        berkuasa = arrayOf(
            "Berkuasa 1299 - 1323",
            "Berkuasa 1323 - 1362",
            "Berkuasa 1362 - 1389",
            "Berkuasa 1389 - 1402",
            "Berkuasa 1413 - 1421",
            "Berkuasa 1421 - 1451",
            "Berkuasa 1444 - 1481",
            "Berkuasa 1481 - 1512",
            "Berkuasa 1512 - 1520",
            "Berkuasa 1520 - 1566"
        )

        biografi = arrayOf(
            getString(R.string.Osman_I),
            getString(R.string.Orhan_I),
            getString(R.string.Murad_I),
            getString(R.string.Bayezid_I),
            getString(R.string.Mehmed_I),
            getString(R.string.Murad_II),
            getString(R.string.Mehmed_II),
            getString(R.string.Bayezid_2),
            getString(R.string.Selim_1),
            getString(R.string.Suleyman_1)
        )

        sultanRecyclerView = findViewById(R.id.sultanRV)
        sultanRecyclerView.layoutManager = LinearLayoutManager(this)
        sultanRecyclerView.setHasFixedSize(true)

        listSultan = arrayListOf<ItemData>()
        getDataUser()
    }

    private fun getDataUser() {
        for ( i in gambar.indices){
            val dataSultan = ItemData(gambar[i],nama[i],berkuasa[i],kesultanan[i])
            listSultan.add(dataSultan)
        }

        var adapter = MyAdapter(listSultan)
        sultanRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                intent = Intent(this@HomeActivity, DetailActivity::class.java)
                intent.putExtra("idgambar",listSultan[position].gambar)
                intent.putExtra("idnama",listSultan[position].nama)
                intent.putExtra("idberkuasa",listSultan[position].berkuasa)
                intent.putExtra("idkesultanan",listSultan[position].kesultanan)
                intent.putExtra("idbiografi",biografi[position])

                startActivity(intent)
            }
        })
    }
}









