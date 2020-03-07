package com.example.asynclearning

import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
        override fun doInBackground(vararg params: Void?): String {
            var toReturn =  ""
            if(text.isNullOrEmpty()){

                toReturn = URL("https://api.icndb.com/jokes/random").readText()

            }
            else {

                val names = text.split(" ")
                val firstName = names[0]
                val lastName = names[1]

                val buildUri1= Uri.parse("https://api.icndb.com/jokes/random").buildUpon()
                    .appendQueryParameter("firstName", firstName)
                    .appendQueryParameter("lastName", lastName)
                    .build().toString()


                toReturn =  URL(buildUri1).readText()
            }

            return toReturn

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val json = JSONObject(result)
//            val innerJson = json.getJSONObject("value")
//            val theJoke = innerJson.getString("joke")
//            hello.text = theJoke
            val innerjson = json.getString("value")
            val jsonInner = JSONObject(innerjson)
            hello.text = jsonInner.getString("joke")
            //Making a JSON object
//            val myJson = JSONObject(result)
//            val innerJson = myJson.getJSONObject("value")
//            val theJoke = innerJson.getString("joke")

//            myJson.getString()
        }
    }

    fun doRequest() {

            var test = asynctask()
            asynctask().execute()


    }

    fun randomJoke(view: View) {
        doRequest();
    }
}
