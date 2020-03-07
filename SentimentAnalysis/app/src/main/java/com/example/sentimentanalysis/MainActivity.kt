package com.example.sentimentanalysis

import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    inner class asynctask() : AsyncTask<Void, Void, String>() {
        val text:String? = editText.text.toString()
        val key = "f732c940176f244ab494d8e1654b6e65"
        var toReturn =  ""
        override fun doInBackground(vararg params: Void?): String {

            if(!text.isNullOrEmpty()){
                val buildUri1= Uri.parse("https://api.meaningcloud.com/sentiment-2.1").buildUpon()
                    .appendQueryParameter("key", key)
                    .appendQueryParameter("lang", "en")
                    .appendQueryParameter("txt", text)
                    .build().toString()


                toReturn =  URL(buildUri1).readText()
            }


            return toReturn

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(toReturn.isNotEmpty()){
                val json = JSONObject(result)

//            val innerJson = json.getJSONObject("value")
//            val theJoke = innerJson.getString("joke")
//            hello.text = theJoke
                val jsonScoreTag = json.getString("score_tag")
                val jsonAgreementVal = json.getString("agreement")
                val jsonIrony = json.getString("irony")



                sentimentView.text = "Your text has a score tag (positive, none, or negative) of ${jsonScoreTag},an agreement value of ${jsonAgreementVal} and an irony value of ${jsonIrony} "

            }
            else {
                sentimentView.text = "please enter some text in first"
            }

        }
    }

    fun doRequest() {

        var test = asynctask()
        asynctask().execute()


    }

    fun sentimentAnalysis(view: View) {
        doRequest();
    }
}
