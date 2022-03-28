package com.example.pizzascheduleapp

import android.R.*
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Month
import java.util.*
import java.util.Calendar.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var slider:SeekBar
        lateinit var value:TextView

        slider=findViewById(R.id.mySeekBar)
        value=findViewById(R.id.myPizzaSize)
        val pizzaSize= arrayListOf<String>("Please Select","Small","Medium","Large","Extra-Large")

        dateBtn.setOnClickListener {
            val c= getInstance()
            val day=c.get(DAY_OF_MONTH)
            val month=c.get(MONTH)
            val year=c.get(YEAR)

            val myDatePicker=DatePickerDialog(this,
                style.ThemeOverlay,DatePickerDialog.OnDateSetListener { DatePicker, Year, Month, Day ->
                    dateText.text="$Day / ${Month+1} /$Year"},year,month,day)
                    myDatePicker.show()
            }

        timeBtn.setOnClickListener {
            val c= Calendar.getInstance()
            val hour=c.get(Calendar.HOUR_OF_DAY)
            val minutes=c.get(Calendar.MINUTE)

            val myTimePicker=TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { TimePicker, hourOfDay, minute ->
                timeText.text="$hourOfDay : $minute"},hour,minutes,false)
            myTimePicker.show()

        }

        scheduleBtn.setOnClickListener {
            var intent = Intent(this,Thanks::class.java)
            intent.putExtra("name",myFullName.text.toString())
            intent.putExtra("phoneNumber",myPhoneNumber.text.toString())
            intent.putExtra("pizzaSize",myPizzaSize.text.toString())
            intent.putExtra("pickupDate",dateText.text.toString())
            intent.putExtra("pickupTime",timeText.text.toString())

            startActivity(intent)
        }

        slider.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text=pizzaSize[progress]
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}