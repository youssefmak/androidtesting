package com.job777.tare5app

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val splashtimeout=4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo == null) {
            Toast.makeText(baseContext, "No internet Connection", Toast.LENGTH_LONG).show()
            this.finish()
        }
        var back = object :Thread(){
            override fun run() {
                try {
                    Thread.sleep(5*1000.toLong())
                    startActivity(Intent(this@MainActivity,second::class.java))
                }catch (ex:Exception){
                    Toast.makeText(baseContext,"error", Toast.LENGTH_LONG).show()
                }
            }
        }
        back.start()
    }
}