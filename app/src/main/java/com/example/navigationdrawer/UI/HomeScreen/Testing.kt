package com.example.navigationdrawer.UI.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ActivityTestingBinding
import java.text.DecimalFormat
import java.text.NumberFormat

class Testing : AppCompatActivity() {
    private lateinit var binding: ActivityTestingBinding
    private var strDisplay = ""
    private var strResult = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            edtNumber.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(
                    text: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                    strResult = text.toString()
                    val formater = DecimalFormat("###,###")
                    strDisplay = formater.format(text.toString().toBigDecimal())
                    edtNumber.setText(strDisplay)
                }

                override fun afterTextChanged(text: Editable?) {
                    strResult = text.toString()
                    val formater = DecimalFormat("###,###")
                    strDisplay = formater.format(text.toString().toBigDecimal())
                    edtNumber.setText(strDisplay)
                }
            }
            )
        }
    }
}