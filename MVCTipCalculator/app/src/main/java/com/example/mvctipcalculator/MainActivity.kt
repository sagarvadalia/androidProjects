package com.example.mvctipcalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tipObj = TipCalculator(0.0, 0.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tipPercent.addTextChangedListener(Watcher())
        total.addTextChangedListener(Watcher())

    }
    inner class Watcher :TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(!tipPercent.text.isNullOrBlank()){
                if(!total.text.isNullOrBlank()){
                    tipObj.tipPercent = tipPercent.text.toString().toDouble() / 100
                    tipObj.total = total.text.toString().toDouble()
                    calculateTip()
                    calculateTotal()

                }

            }

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    fun calculateTip(){

        tipAmount.text = tipObj.totalTip.toString()
    }
    fun calculateTotal(){
        totalPlusTip.text = tipObj.finalTotal.toString()
    }
}

