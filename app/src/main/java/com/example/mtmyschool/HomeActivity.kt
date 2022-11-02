package com.example.mtmyschool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.mtmyschool.databinding.ActivityHomeBinding
import com.example.mtmyschool.databinding.ActivityloginBinding

class HomeActivity:AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}