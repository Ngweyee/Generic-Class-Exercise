package com.littlelemon.genericclassexercise

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val tax = 200.0.calculateTax(0.065)
        var tax_textView = findViewById<TextView>(R.id.tax_textView)
        tax_textView.text = "Tax for $200 is equal to $tax"

        val saveData_Button = findViewById<Button>(R.id.saveDataButton)
        saveData_Button.setOnClickListener {
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
            println(it.id)
        }
    }

    // lambda function
    var taxCalculator : (Double, Double) -> Double = { price, taxRatio ->
        price * taxRatio
    }

    // Extension Function
    var calculateTax : Double.(Double) -> Double = { taxRatio ->
        this * taxRatio
    }
}