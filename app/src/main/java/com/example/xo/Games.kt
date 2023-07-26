package com.example.xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.xo.databinding.ActivityGamesBinding
import com.example.xo.databinding.ActivityMainBinding

class Games : AppCompatActivity() {

    private lateinit var binding : ActivityGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.XOBtn.setOnClickListener {
            var intent = Intent(this, XO::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnTouchListener { v, event ->
            when(event?.action){
                MotionEvent.ACTION_DOWN ->
                    binding.backBtn.setBackgroundResource(R.drawable.back_pushed)
                MotionEvent.ACTION_UP ->
                    binding.backBtn.setBackgroundResource(R.drawable.back)
            }
            v?.onTouchEvent(event) ?: true
        }

        binding.XOBtn.setOnTouchListener { v, event ->
            when(event?.action){
                MotionEvent.ACTION_DOWN ->
                    binding.XOBtn.setBackgroundResource(R.drawable.xo_pushed)
                MotionEvent.ACTION_UP ->
                    binding.XOBtn.setBackgroundResource(R.drawable.xo)
            }
            v?.onTouchEvent(event) ?: true
        }


    }
}