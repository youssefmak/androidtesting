package com.job777.tare5app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.four.*

class ten : AppCompatActivity() {

    var valques: Array<String>? = null

    var valans: Array<String>? = null

    var index: Int? = null

    var deftext = "  press A  for answer"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.ten)

        //  R.array.ans
        valques = resources.getStringArray(R.array.ques7)

        valans = resources.getStringArray(R.array.ans7)


        index = 0


        tvans.text = deftext


        tvques.text = "${valques!![index!!]}"
        tv1.text = "${index!! + 1}" + "/"
        tv2.text = "${valques!!.size}"


    }

    fun action(v: View?) {
        when (v?.id) {
            R.id.br -> {
                try {
                    tvans.text = deftext
                    index = index!! - 1
                    tvques.text = "${valques!![index!!]}"
                    tv1.text = (index!! + 1).toString() + "/"
                } catch (ex: Exception) {
                    index = valques!!.size - 1
                    tvques.text = "${valques!![index!!]}"
                    tv1.text = (index!! + 1).toString() + "/"


                }


            }


            R.id.bm -> {


                tvans.text = "${valans!![index!!]}"

            }

            R.id.bl -> {
                try {
                    tvans.text = deftext
                    index = index!! + 1
                    tvques.text = "${valques!![index!!]}"
                    tv1.text = (index!! + 1).toString() + "/"
                } catch (ex: Exception) {
                    //look and change the 7 here when you write all questions in string ques
                    index = 20 - valques!!.size
                    tvques.text = "${valques!![index!!]}"
                    tv1.text = (index!! + 1).toString() + "/"

                }

            }

        }


    }


}
