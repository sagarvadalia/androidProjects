package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   var currencyConverter = Converter(0.0, "US Dollars", "US Dollars");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputCurrencySpinner.adapter = ArrayAdapter.createFromResource(this, R.array.currencies, R.layout.support_simple_spinner_dropdown_item)
        outputCurrencySpinner.adapter = ArrayAdapter.createFromResource(this, R.array.currencies, R.layout.support_simple_spinner_dropdown_item)
        inputCurrencySpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currencyConverter.inputCurrency = this@MainActivity.inputCurrencySpinner.getItemAtPosition(position).toString()
                //var toast = Toast.makeText(applicationContext, currencyConverter.inputCurrency, Toast.LENGTH_LONG)
                //toast.show()
                outputValue.text = currencyConverter.output.toString()
                currencyConverter.flagMap[currencyConverter.inputCurrency]?.let {

                    inputFlag.setImageResource(

                        it
                    )
                }



            }
        }
        outputCurrencySpinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currencyConverter.outputCurrency = this@MainActivity.inputCurrencySpinner.getItemAtPosition(position).toString()
                var toast = Toast.makeText(applicationContext, "You have ${currencyConverter.output.toString()} ${currencyConverter.outputCurrency}", Toast.LENGTH_LONG)
                toast.show()
                outputValue.text = currencyConverter.output.toString()
                currencyConverter.flagMap[currencyConverter.outputCurrency]?.let {
                    Log.i("change the flag", "changing the flag here");
                    outputFlag.setImageResource(

                        it
                    )
                }
            }
        }
        currencyConverter.input = 15.0;
        inputValue.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(!inputValue.text.isNullOrBlank()){
                    currencyConverter.input= inputValue.text.toString().toDouble()
                    outputValue.text = currencyConverter.output.toString()
                    var toast = Toast.makeText(applicationContext, "You have ${currencyConverter.output.toString()} ${currencyConverter.outputCurrency}", Toast.LENGTH_LONG)
                    toast.show()
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        outputValue.text = currencyConverter.output.toString()

            //var toast = Toast.makeText(applicationContext, currencyConverter.inputCurrency, Toast.LENGTH_LONG)
//        toast.show()
//        toast = Toast.makeText(applicationContext, currencyConverter.outputCurrency, Toast.LENGTH_LONG)
//        toast.show()
//        toast = Toast.makeText(applicationContext, currencyConverter.conversionRate.toString(), Toast.LENGTH_LONG);
//        toast.show()



    }
}
