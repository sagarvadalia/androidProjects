package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calc.R

class MainActivity : AppCompatActivity() {
    private var total = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onButtonClick(v: View){
        val button = v as Button
        val btnText = button.text.toString()
        val value = btnText.toInt()
        total += value
//        total.text
//        total.text = total.toString()
    }
}
