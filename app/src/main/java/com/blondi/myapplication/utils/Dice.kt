package com.blondi.myapplication.utils

import android.content.res.Resources
import android.util.Log
import android.widget.ImageView
import com.blondi.myapplication.R
import com.blondi.myapplication.interfaces.rollable
import java.util.*


/**
 * Created by Enio on 5/6/2019.
 */
class Dice (private val dicePicture: ImageView) : rollable{

    var currentState : Int= 6

    override fun roll(){

        fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start
        currentState = (1..6).random()
        Log.d("Dice: ","Current state :"+currentState)
        refreshImage()
    }

    fun setNewImage(resource: Int) {
        dicePicture.setImageResource(resource)
    }


    private fun refreshImage() {
        if(currentState==1)
        dicePicture.setImageResource(R.drawable.one)
        if(currentState==2)
            dicePicture.setImageResource(R.drawable.two)
        if(currentState==3)
            dicePicture.setImageResource(R.drawable.three)
        if(currentState==4)
            dicePicture.setImageResource(R.drawable.four)
        if(currentState==5)
            dicePicture.setImageResource(R.drawable.five)
        if(currentState==6)
            dicePicture.setImageResource(R.drawable.six)

    }


}