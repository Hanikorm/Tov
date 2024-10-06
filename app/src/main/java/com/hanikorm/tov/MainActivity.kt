package com.hanikorm.tov

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextProductName = findViewById<EditText>(R.id.editTextProductName)
        val button = findViewById<Button>(R.id.button)
        val buttonExit = findViewById<Button>(R.id.buttonExit)

        button.setOnClickListener {
            val productName = editTextProductName.text.toString()
            if (isValidProductName(productName)){
                Toast.makeText(this, "Название товара корректное", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Название товара не корректное", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidProductName(productName: String): Boolean {
        if (productName.isEmpty() || productName[0] !in 'А'..'Я' && productName[0] != 'Ё') {
            return false
        }

        for (char in productName) {
            if (!char.isLetter() && !char.isDigit() && char != ' ') {
                return false
            }
            if ((char in 'А'..'я').not() && char != 'Ё' && char != 'ё' && !char.isDigit() && char != ' ') {
                return false
            }
        }

        return true
    }

}