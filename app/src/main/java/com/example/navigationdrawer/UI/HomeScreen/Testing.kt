package com.example.navigationdrawer.UI.HomeScreen

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.navigationdrawer.R

class Testing : AppCompatActivity() {

    private lateinit var textView:TextView
    private lateinit var button: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_testing)
        //find id
        textView = findViewById(R.id.text_dates)
        button   = findViewById(R.id.button)
        //

        //set onclick to button
        button.setOnClickListener {
            // create object from date picker
            val dialog = DatePickerDialog(this)

            // get text from selected date
            dialog.setOnDateSetListener { _, year, month, dayOfMonth ->

                    textView.text = "Selected Date: $dayOfMonth / ${month+1} / $year"


            }
            dialog.show()
        }


    }



}