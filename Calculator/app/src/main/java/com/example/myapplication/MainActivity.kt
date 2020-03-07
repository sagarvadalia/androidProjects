package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var total = 0
    private var multiDigit = ""
    private var shouldSubtract = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onButtonClick(v: View){
        val button = v as Button
        val btnText = button.text.toString()
        val value = btnText.toInt()
        multiDigit += value
        if(shouldSubtract){
            calcTotal.text = "${total} - ${multiDigit}"
        }
        if(!shouldSubtract){
            calcTotal.text = "${total} + ${multiDigit}"
        }
    }
    fun sumUp(v: View){
        if(multiDigit.equals("")){
            return
        }
        if(!shouldSubtract){
            total += multiDigit.toInt()
            calcTotal.text = total.toString()
            calcTotal.text = "${calcTotal.text}  + "
            multiDigit = ""

        }
        if(shouldSubtract){
            total -= multiDigit.toInt()
            calcTotal.text = total.toString()
            calcTotal.text = "${calcTotal.text} - "
            multiDigit = ""
        }



    }
    fun clearTotal(view: View) {

        total = 0
        multiDigit = ""
        if(!shouldSubtract){
            calcTotal.text = "0  + "
        }
        if(shouldSubtract){
            calcTotal.text = "0  - "
        }

    }

    fun add(view: View) {
        if(multiDigit.equals("")){
            calcTotal.text = "${total}  + "
            shouldSubtract = false
        }

    }
    fun subtract(view: View) {
        if(multiDigit.equals("")){
            calcTotal.text = "${total}  -"
            shouldSubtract = true
        }

    }
}

