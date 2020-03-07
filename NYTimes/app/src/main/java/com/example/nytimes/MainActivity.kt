package com.example.nytimes

import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    inner class asyncTask() : AsyncTask<String, Void, String>(){
        val key = "RhSAsECpNOATiX6HdQqNLqG2e0ypAzqv"
        val secret = "5Oz5gDU9MnKpySKn"
        var text = editText.text.toString()
        override fun doInBackground(vararg params: String?): String {
            var toReturn = ""


            val buildUri1= Uri.parse("https://api.nytimes.com/svc/search/v2/articlesearch.json").buildUpon()
                .appendQueryParameter("api-key", key)
                .appendQueryParameter("sort", "newest")


                .appendQueryParameter("query", "headline:${text}")

                .build().toString()


            toReturn =  URL(buildUri1).readText()
            Log.i("tessssttttttttt", buildUri1.toString());


            return toReturn
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            var jsonObject = JSONObject(result)
            if (result !== "") {

                var stringVal = jsonObject.getString("response")
                jsonObject = JSONObject(stringVal);
                var stringVal2 = jsonObject.getJSONArray("docs")

                var headlines = arrayOfNulls<String>(10)
                textView.text = ""
                for (i in headlines.indices) {

                    var x = stringVal2.getString(i);
                    var obj = JSONObject(x);
                    x = obj.getString("headline")
                    obj = JSONObject(x)
                    headlines[i] = obj.getString("main")
                    textView.text = "${textView.text}  ${headlines[i]}"

                    textView.setMovementMethod(ScrollingMovementMethod())

                }
                sentimentAnalysis().execute()


            }
        }


    }














    inner class sentimentAnalysis() : AsyncTask<String, Void, String>(){
        val x = findViewById<TextView>(textView.id)
        val key = "f732c940176f244ab494d8e1654b6e65"
       val text = textView.text.toString()
        var toReturn = ""


        override fun doInBackground(vararg params: String?): String {



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
                val jsonConfidence = json.getString("confidence")



                sentimentView.text = "Your text has a score tag (positive, none, or negative) of ${jsonScoreTag},an agreement value of ${jsonAgreementVal} and an irony value of ${jsonIrony} and we are ${jsonConfidence}% confident "

            }
            else {
                sentimentView.text = "please enter some text in first"
            }

        }
    }















    fun buttonClick(view: View){
        var className = asyncTask();
        className.execute("hello", "abc", "abc")
        doRequest()
//


    }
    fun doRequest() {

        var test = asyncTask()
        asyncTask().execute()


    }
}
