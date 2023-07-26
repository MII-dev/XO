package com.example.xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.xo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        setContentView(view)

        binding.chooseBtn.setOnClickListener {
            val intent = Intent(this, Games::class.java)
            startActivity(intent)

        }

        binding.settingBtn.setOnClickListener {

        }

        binding.chooseBtn.setOnTouchListener { v, event ->
            when(event?.action){
                MotionEvent.ACTION_DOWN ->
                    binding.chooseBtn.setBackgroundResource(R.drawable.choose_pushed)
                MotionEvent.ACTION_UP ->
                    binding.chooseBtn.setBackgroundResource(R.drawable.choose_game)
            }
            v?.onTouchEvent(event) ?: true
        }

        binding.settingBtn.setOnTouchListener { v, event ->
            when(event?.action){
                MotionEvent.ACTION_DOWN->
                    binding.settingBtn.setBackgroundResource(R.drawable.settings_pushed)
                MotionEvent.ACTION_UP ->
                    binding.settingBtn.setBackgroundResource(R.drawable.settings)
            }
            v?.onTouchEvent(event) ?: true
        }












    }
}