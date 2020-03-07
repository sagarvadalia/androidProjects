package com.example.currencyconverter

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject
import java.net.URL

class Async : AsyncTask<Void, Void, String>() {
    val fixerAPIKey ="3c7ca662fe0ffec8479f9d16445ea814"
    val endpoint:String = "http://data.fixer.io/api/latest/${fixerAPIKey}"
    override fun doInBackground(vararg params: Void?): String {
        var toReturn = ""

        toReturn = URL("http://data.fixer.io/api/latest/${fixerAPIKey}").readText()
        //....

        return toReturn
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Log.i("json val", result)

    }
}