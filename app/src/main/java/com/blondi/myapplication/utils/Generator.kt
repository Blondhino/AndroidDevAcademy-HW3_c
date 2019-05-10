package com.blondi.myapplication.utils

import android.widget.ImageView

/**
 * Created by Enio on 5/9/2019.
 */
class Generator {

    public fun generateDices(Images :MutableList<ImageView>): MutableList<Dice>{
        var Dices: MutableList<Dice> = mutableListOf()
        for (i in 0 until Images.size) Dices.add(i, Dice(Images[i]))
        return Dices
    }
}