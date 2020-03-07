package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.support_simple_spinner_dropdown_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var color = spinner.getItemAtPosition(position).toString()
                var colorInt:Int = 0;
                if (color == "Red"){
                    colorInt = ContextCompat.getColor(this@MainActivity, R.color.red)
                    Log.i("colorInt", colorInt.toString())
                    background_layout.setBackgroundColor(colorInt)
                    var toast= Toast.makeText(applicationContext, colorInt.toString() + "abc", Toast.LENGTH_LONG)
                    toast.show()
                }
                if (color == "Yellow"){


                    colorInt = ContextCompat.getColor(this@MainActivity, R.color.yellow)
                    Log.i("colorInt", colorInt.toString())
                    background_layout.setBackgroundColor(colorInt)
                    var toast= Toast.makeText(applicationContext, colorInt.toString() + "abc", Toast.LENGTH_LONG)
                    toast.show()
                }
                if (color == "Blue"){
                    colorInt = ContextCompat.getColor(this@MainActivity, R.color.blue)
                    Log.i("colorInt", colorInt.toString())
                    background_layout.setBackgroundColor(colorInt)
                    var toast= Toast.makeText(applicationContext, colorInt.toString() + "abc", Toast.LENGTH_LONG)
                    toast.show()
                }



                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }
}
