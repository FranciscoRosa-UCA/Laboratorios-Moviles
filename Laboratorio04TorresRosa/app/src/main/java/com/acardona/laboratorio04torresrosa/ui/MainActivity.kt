package com.acardona.laboratorio04torresrosa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.acardona.laboratorio04torresrosa.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var  nameEditText: TextInputEditText
    private lateinit var  emailEditText: TextInputEditText
    private lateinit var  numberEditText: TextInputEditText

    private lateinit var  actionNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        listener()

    }

    private fun bind(){
        nameEditText = findViewById(R.id.name_text_view)
        emailEditText = findViewById(R.id.email_text_view)
        numberEditText = findViewById(R.id.number_text_view)
        actionNext = findViewById(R.id.guardar_button)
    }

    private fun listener(){
        actionNext.setOnClickListener{
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra(SHARE_NAME, nameEditText.text.toString())
            intent.putExtra(SHARE_EMAIL, emailEditText.text.toString())
            intent.putExtra(SHARE_NUMBER, numberEditText.text.toString())
            startActivity(intent)
        }
    }

    companion object{
        const val SHARE_NAME = "name"
        const val SHARE_EMAIL = "email"
        const val SHARE_NUMBER = "number"
    }

}