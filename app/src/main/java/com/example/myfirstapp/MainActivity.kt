package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

		val rollButton: Button = findViewById(R.id.button)
		rollButton.setOnClickListener { rollDice() }
		
		//do a dice roll when the app starts
		rollDice()
  }
	
	private fun rollDice() {
		// Create a Dice with 6 sides and roll it
		val dice = Dice(6)
		val diceRoll = dice.roll()
		
		// Update the screen with the result
		val diceImage: ImageView = findViewById(R.id.imageView)
		val drawableResource = when (diceRoll) {
			1 -> R.drawable.dice_1
			2 -> R.drawable.dice_2
			3 -> R.drawable.dice_3
			4 -> R.drawable.dice_4
			5 -> R.drawable.dice_5
			else -> R.drawable.dice_6
		}
		diceImage.setImageResource(drawableResource)
		// screen readers
		diceImage.contentDescription = diceRoll.toString()
	}
}

class Dice(private val numSides: Int) {

  fun roll(): Int {
    return (1..numSides).random()
  }
}