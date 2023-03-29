package com.uca.laboratorio03torresrosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var fiveCentsImageView: ImageView
    private lateinit var tenCentsImageView: ImageView
    private lateinit var quarterCentsImageView: ImageView
    private lateinit var dollarImageView: ImageView

    private  lateinit var cashTextVIew: TextView

    private var cash = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        clickListeners()

    }

    private fun bind(){
        fiveCentsImageView = findViewById(R.id.five_cents_ImageView)
        tenCentsImageView = findViewById(R.id.ten_cents_ImageView)
        quarterCentsImageView = findViewById(R.id.quarter_ImageView)
        dollarImageView = findViewById(R.id.dollar_ImageView)
        cashTextVIew = findViewById(R.id.cash_TextView)
    }

    private fun clickListeners(){
        fiveCentsImageView.setOnClickListener{
            cash += 0.05
            updateTextView()
        }

        tenCentsImageView.setOnClickListener{
            cash += 0.1
            updateTextView()
        }

        quarterCentsImageView.setOnClickListener{
            cash += 0.25
            updateTextView()
        }

        dollarImageView.setOnClickListener{
            cash += 1.0
            updateTextView()
        }


    }

    private fun updateTextView(){
        cash = String.format("%.2f", cash).toDouble()
        cashTextVIew.text = "$${cash}"
    }

}

