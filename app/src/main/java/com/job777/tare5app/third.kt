package com.job777.tare5app

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.third.*

class third : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)




        val cm= baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        MobileAds.initialize(this,
            "ca-app-pub-7757590907378676~2257972496")//sdk
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-7757590907378676/8133115707"//beny
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)





        button2.setOnClickListener {


            mInterstitialAd.adListener = object: AdListener() {
                override fun onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                    startActivity(Intent(this@third,f ::class.java))
                }
            }



            if (mInterstitialAd.isLoaded) {
                // startActivity(Intent(this@second, third::class.java))
                mInterstitialAd.show()

            } else {

                Log.d("TAG", "The interstitial wasn't loaded yet.")
                startActivity(Intent(this@third,f::class.java))


                // startActivity(Intent(this@second, third::class.java))
            }






        }

        button3.setOnClickListener {

            mInterstitialAd.adListener = object: AdListener() {
                override fun onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                    startActivity(Intent(this@third,f ::class.java))
                }
            }




            if (mInterstitialAd.isLoaded) {
                // startActivity(Intent(this@second, third::class.java))
                mInterstitialAd.show()

            } else {

                Log.d("TAG", "The interstitial wasn't loaded yet.")
                startActivity(Intent(this@third,f2::class.java))


                // startActivity(Intent(this@second, third::class.java))
            }

        }
        p.setOnClickListener {

            var i = Intent(Intent.ACTION_VIEW)
            i.data= Uri.parse("https://www.facebook.com/groups/692407984528534/")
            startActivity(i)
            mInterstitialAd.show()
        }








    }
}
