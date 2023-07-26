package com.example.xo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import com.example.xo.databinding.ActivityXoBinding
class XO : AppCompatActivity() {

    private lateinit var binding : ActivityXoBinding

    var xo = "X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXoBinding.inflate(layoutInflater)
        var view = binding.root

        setContentView(view)

        var buttons: Array<TextView> = arrayOf( binding.leftTopCorner, binding.topMid, binding.rightTopCorner,
            binding.leftMid, binding.mid, binding.rightMid,
            binding.leftBottomCorner, binding.bottomMid, binding.rightBottomCorner)

        buttons[0].setOnClickListener {
            step(xo,binding.leftTopCorner, buttons)
        }

        buttons[1].setOnClickListener {
            step(xo,binding.topMid, buttons)
        }

        buttons[2].setOnClickListener {
            step(xo,binding.rightTopCorner, buttons)
        }

        buttons[3].setOnClickListener {
            step(xo,binding.leftMid, buttons)
        }

        buttons[4].setOnClickListener {
            step(xo,binding.mid, buttons)
        }

        buttons[5].setOnClickListener {
            step(xo,binding.rightMid, buttons)
        }

        buttons[6].setOnClickListener {
            step(xo,binding.leftBottomCorner, buttons)
        }

        buttons[7].setOnClickListener {
            step(xo,binding.bottomMid, buttons)
        }

        buttons[8].setOnClickListener {
            step(xo,binding.rightBottomCorner, buttons)
        }

        binding.restartBtn.setOnClickListener {
            restart(buttons)
        }

        binding.backBtn.setOnClickListener {
            val intent = Intent(this,Games::class.java)
            startActivity(intent)

        }

        binding.backBtn.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN ->
                    binding.backBtn.setBackgroundResource(R.drawable.back_pushed)
                MotionEvent.ACTION_UP ->
                    binding.backBtn.setBackgroundResource(R.drawable.back)
            }
            v?.onTouchEvent(event) ?: true
        }

        binding.restartBtn.setOnTouchListener { v, event ->
            when (event?.action){
                MotionEvent.ACTION_DOWN ->
                    binding.restartBtn.setBackgroundResource(R.drawable.restart_pushed)
                MotionEvent.ACTION_UP ->
                    binding.restartBtn.setBackgroundResource(R.drawable.restart)
            }
            v?.onTouchEvent(event) ?: true
        }


    }

    private fun step(x_o: String, button: TextView, array: Array<TextView>){
        if (x_o == "X") {
            button.setBackgroundResource(R.drawable.x)
            button.text = "X"
            if(checkWin(button))
                disableBtns(array)
            button.isEnabled = false
            xo = "O"

        }
        else {
            button.setBackgroundResource(R.drawable.o)
            button.text = "O"
            if(checkWin(button))
                disableBtns(array)
            button.isEnabled = false
            xo = "X"
        }
    }

    private fun checkWin(button: TextView): Boolean {

        when(button){
            binding.leftTopCorner -> {
                if (button.text == binding.topMid.text
                    && button.text == binding.rightTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.leftMid.text
                    && button.text == binding.leftBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.rightBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.topMid -> {
                if (button.text == binding.leftTopCorner.text
                    && button.text == binding.rightTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.bottomMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.rightTopCorner -> {
                if (button.text == binding.leftTopCorner.text
                    && button.text == binding.topMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.rightMid.text
                    && button.text == binding.rightBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.leftBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.leftMid -> {
                if (button.text == binding.leftTopCorner.text
                    && button.text == binding.leftBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.rightMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.leftBottomCorner -> {
                if (button.text == binding.leftMid.text
                    && button.text == binding.leftTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.rightTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.bottomMid.text
                    && button.text == binding.rightBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.bottomMid -> {
                if (button.text == binding.leftBottomCorner.text
                    && button.text == binding.rightBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.topMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.rightBottomCorner -> {
                if (button.text == binding.bottomMid.text
                    && button.text == binding.leftBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.leftTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.rightMid.text
                    && button.text == binding.rightTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.rightMid -> {
                if (button.text == binding.rightBottomCorner.text
                    && button.text == binding.rightTopCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.mid.text
                    && button.text == binding.leftMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
            }
            binding.mid -> {
                if (button.text == binding.leftTopCorner.text
                    && button.text == binding.rightBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.rightTopCorner.text
                    && button.text == binding.leftBottomCorner.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.topMid.text
                    && button.text == binding.bottomMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }
                if (button.text == binding.leftMid.text
                    && button.text == binding.rightMid.text) {
                    binding.result.text = "Win " + button.text
                    return true
                }

            }
        }
        return false
    }

    private fun restart(array: Array<TextView>){

        xo = "X"

        binding.result.text = ""

        array.forEach {
            el -> el.text = ""
            el.setBackgroundResource(R.drawable.empty)
            el.isEnabled = true

        }

    }

    private fun disableBtns(array: Array<TextView>){
        array.forEach {
                el -> el.isEnabled = false
        }
    }

}