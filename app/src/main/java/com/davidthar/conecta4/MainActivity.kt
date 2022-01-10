package com.davidthar.conecta4

/*
* Coded by @DavidThar
* Challenge #1 (January)
* for Monthly-App-Challenge-2022 by MoureDev
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidthar.conecta4.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPlay.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

        binding.btnInfo.setOnClickListener {
            val intent = Intent(this,InfoActivity::class.java)
            startActivity(intent)
        }
    }
}