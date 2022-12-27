package com.example.galadarbs

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    var calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculator_input.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                onTextEdit()
            }
        })
    }

    fun calculateCharFrequency(view: View) {
        hideKeyboard(this)
        val chars = this.calculator.calculateCharFrequency(calculator_input.text)
        val resultList = findViewById<ListView>(R.id.calculator_result_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chars)
        resultList.adapter = adapter
    }

    private fun onTextEdit()
    {
        val resultList = findViewById<ListView>(R.id.calculator_result_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, emptyList<Int>())
        resultList.adapter = adapter
    }


}
