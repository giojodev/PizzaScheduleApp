package com.example.pizzascheduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thanks.*

class Thanks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
        nameid.text=intent.getStringExtra("name")
        phoneid.text=intent.getStringExtra("phoneNumber")
        sizeid.text=intent.getStringExtra("pizzaSize")
        dateid.text=intent.getStringExtra("pickupDate")
        timeid.text=intent.getStringExtra("pickupTime")

        sendBtn.setOnClickListener {
            rateText.text=myRatingBar.rating.toString()
        }
    }
}