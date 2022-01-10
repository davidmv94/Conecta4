package com.davidthar.conecta4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidthar.conecta4.databinding.ActivityInfoBinding

private lateinit var binding : ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val githubUri = "https://github.com/davidthar"
        val twitterUri = "https://twitter.com/DavidThar"
        val moureUri = "https://github.com/mouredev/Monthly-App-Challenge-2022"


        binding.ivGithub.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(githubUri)))
        }

        binding.ivTwitter.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(twitterUri)))
        }

        binding.moureGit.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(moureUri)))
        }
    }
}