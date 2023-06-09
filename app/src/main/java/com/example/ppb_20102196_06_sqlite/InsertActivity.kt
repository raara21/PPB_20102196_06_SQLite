package com.example.ppb_20102196_06_sqlite

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.ppb_20102196_06_sqlite.databinding.ActivityInsertBinding
import com.example.ppb_20102196_06_sqlite.databinding.ActivityMainBinding

class InsertActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSubmit.setOnClickListener{
            val email = binding.inputEmail.text.toString()
            val nama = binding.inputNama.text.toString()
            val nim = binding.inputNim.text.toString()
            val pass = binding.inputPassword.text.toString()
            val db = MahasiswaHelper(this)
            val mahasiswa = Mahasiswa(email, nama, nim, pass)

            if(nama.isNotEmpty() && nim.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()){
                db.insertData(mahasiswa)
                Toast.makeText(this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                setResult(Activity.RESULT_OK)
                finish()
            } else{
                Toast.makeText(this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            } else -> super.onContextItemSelected(item)
        }
    }
}