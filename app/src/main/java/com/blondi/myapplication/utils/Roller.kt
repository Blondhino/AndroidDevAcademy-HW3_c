package com.blondi.myapplication.utils

import android.util.Log
import android.widget.Toast

/**
 * Created by Enio on 5/9/2019.
 */
class Roller(var Dices : MutableList<Dice>) {
    fun classicRoll(){
        Log.e("Classic roller: ","called")
        for (i in 0 until Dices.size)
        Dices[i].roll()


    }


    fun selctiveRoll (selections : MutableList<Int>){
        for (i in 0 until selections.size){
            if (selections[i]==1)
            Dices[i].roll()
        }
    }
}