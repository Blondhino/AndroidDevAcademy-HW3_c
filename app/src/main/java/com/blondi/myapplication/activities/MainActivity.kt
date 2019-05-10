package com.blondi.myapplication.activities

import android.widget.ImageView
import android.widget.Toast
import com.blondi.myapplication.R
import com.blondi.myapplication.R.layout.dices
import com.blondi.myapplication.utils.BaseActivity
import com.blondi.myapplication.utils.Dice
import com.blondi.myapplication.utils.Generator
import com.blondi.myapplication.utils.Roller
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dices.*


class MainActivity: BaseActivity() {


    private var diceImages :MutableList<ImageView> = mutableListOf()
    private var rollCounter=0
    private var selections= mutableListOf<Int>()
    private var dices= mutableListOf<Dice>()
    private var roller=Roller(dices)


    override fun setupUI() {
         getImages()
         dices = Generator().generateDices(diceImages)
         roller = Roller(dices)
        initializeSelections(selections)
        RollBtn.setOnClickListener { rollerHandler(roller)}
    }

    private fun rollerHandler(roller:Roller) {
       if (rollCounter%2==0){
           println("Classic roll")
           roller.classicRoll()
           rollCounter++
       }else{
           clearSelections(selections)
           selectHandler()
           rollCounter++


       }

    }

    private fun selectHandler() {
        Toast.makeText(this,R.string.selectiveMsg,Toast.LENGTH_SHORT).show()
        RollBtn.setOnClickListener{roller.selctiveRoll(selections); println("Selective roll with"+selections); recastBtn()}
        dice1_image.setOnClickListener { makeSelection(dices[0]); selections[0]=0; dice1_image.setOnClickListener { };  }
        dice2_image.setOnClickListener { makeSelection(dices[1]); selections[1]=0; dice1_image.setOnClickListener { };  }
        dice3_image.setOnClickListener { makeSelection(dices[2]); selections[2]=0; dice1_image.setOnClickListener { };  }
        dice4_image.setOnClickListener { makeSelection(dices[3]); selections[3]=0; dice1_image.setOnClickListener { };  }
        dice5_image.setOnClickListener { makeSelection(dices[4]); selections[4]=0; dice1_image.setOnClickListener { };  }
        dice6_image.setOnClickListener { makeSelection(dices[5]); selections[5]=0; dice1_image.setOnClickListener { };  }




    }

    private fun recastBtn() {
        RollBtn.setOnClickListener { rollerHandler(roller)}
    }


    private fun makeSelection(dice: Dice) {
        if (dice.currentState==1) {dice.setNewImage(R.drawable.oneselected) }
        if (dice.currentState==2) {dice.setNewImage(R.drawable.twoselected) }
        if (dice.currentState==3) {dice.setNewImage(R.drawable.threeselected) }
        if (dice.currentState==4) {dice.setNewImage(R.drawable.fourselected) }
        if (dice.currentState==5) {dice.setNewImage(R.drawable.fiveselected) }
        if (dice.currentState==6) {dice.setNewImage(R.drawable.sixselected) }



    }


    private fun initializeSelections(selections: MutableList<Int>) {
        for (i in 0..5){
            selections.add(i,1)
        }
    }
    private fun getImages() {
        diceImages.add(0,dice1_image)
        diceImages.add(1,dice2_image)
        diceImages.add(2,dice3_image)
        diceImages.add(3,dice4_image)
        diceImages.add(4,dice5_image)
        diceImages.add(5,dice6_image)

    }
    private fun clearSelections(selections : MutableList<Int>){
        for (i in 0..5){
        selections[i]=1
        }

    }
    override fun getLayoutId(): Int {
        return  R.layout.activity_main
    }


}




