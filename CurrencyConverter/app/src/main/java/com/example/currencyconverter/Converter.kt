package com.example.currencyconverter

import android.util.Log


class Converter(input:Double, inputCurrency: String, outputCurrency: String)  {
    var flagMap:HashMap<String, Int> = HashMap()
    var conversionRate:Double = getConversionRate(inputCurrency, outputCurrency);
    var inputCurrency : String = "US Dollars"
        set(value){
            field = value
            conversionRate = getConversionRate(inputCurrency, outputCurrency)
            var output = input * conversionRate
        }
    var outputCurrency: String = "US Dollars"
        set(value){
            field = value
            conversionRate = getConversionRate(inputCurrency, outputCurrency)
            Log.i("Here we are", "here we are");
            var output = input * conversionRate
        }
    private fun getConversionRate(inputCurrency: String, outputCurrency: String): Double {
        var currencyVals:HashMap<String, Double> = HashMap<String, Double>()
        currencyVals["US Dollars"] = 1.0;
        currencyVals["Euro"] = .93
        currencyVals["Chinese Yuan"] = 7.0
        currencyVals["Mexican Pesos"] = 18.59
        currencyVals["Canadian Dollars"] = 1.33
        flagMap["US Dollars"] = R.drawable.usflag
        flagMap["Euro"] = R.drawable.euroflag
        flagMap["Chinese Yuan"] = R.drawable.chineseflag
        flagMap["Mexican Pesos"] = R.drawable.mexicanflag
        flagMap["Canadian Dollars"] = R.drawable.canadianflag

        val output = currencyVals[outputCurrency]?:0.0
        val input = currencyVals[inputCurrency]?:0.0
        var rate = output/input
        return rate;
    }

    var output = input * conversionRate


    var input: Double = 0.0
        set(value){
            field = value
            output = input * conversionRate
        }
}