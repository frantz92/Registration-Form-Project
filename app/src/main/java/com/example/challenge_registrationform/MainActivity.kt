package com.example.challenge_registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadSpinner()
        button_submit.setOnClickListener { onClickedSubmit() }
    }

    private fun loadSpinner() {
        val levelTitles = arrayOf(
            "Pyrenees",
            "Alp",
            "Caucasus",
            "Cordillera",
            "Andes",
            "Karakorum",
            "Himalaya",
            "The Seven Summits"
        )
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, levelTitles)
        spinner_title.adapter = spinnerAdapter
    }

    private fun onClickedSubmit() {

        val userInfo = UserInfo(
            spinner_title.selectedItem as String,
            text_input_first_name.text.toString(),
            text_input_last_name.text.toString(),
            text_input_email.text.toString(),
            text_input_phone.text.toString(),
            text_input_password.text.toString()
        )

        val previewActivityIntent = Intent(this, MessageActivity::class.java)
        previewActivityIntent.putExtra("UserInfo", userInfo)
        startActivity(previewActivityIntent)
    }
}