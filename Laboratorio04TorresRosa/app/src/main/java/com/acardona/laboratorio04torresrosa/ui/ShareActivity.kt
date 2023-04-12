package com.acardona.laboratorio04torresrosa.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.acardona.laboratorio04torresrosa.R
import com.google.android.material.textfield.TextInputEditText

class ShareActivity : AppCompatActivity() {

    private lateinit var  nameResultTextView: TextView
    private lateinit var  emailResultTextView: TextView
    private lateinit var  numberResultTextView: TextView
    private lateinit var  shareResultButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        bind()
        update()
        listener()

    }


    private fun bind(){
        nameResultTextView = findViewById(R.id.name_result_text_view)
        emailResultTextView = findViewById(R.id.email_result_text_view)
        numberResultTextView = findViewById(R.id.number_result_text_view)
        shareResultButton = findViewById(R.id.share_result_button)
    }

    private fun update(){
        nameResultTextView.text = intent.getStringExtra(MainActivity.SHARE_NAME).toString()
        emailResultTextView.text = intent.getStringExtra(MainActivity.SHARE_EMAIL).toString()
        numberResultTextView.text = intent.getStringExtra(MainActivity.SHARE_NUMBER).toString()

    }

    private fun listener(){

        shareResultButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND

                putExtra(Intent.EXTRA_TEXT,
                    "Nombre: "+ nameResultTextView.text +"\n"+
                            "Correo: "+ emailResultTextView.text +"\n"+
                        "Telefono: "+ numberResultTextView.text )

                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

}