package com.example.challenge_registrationform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {

    lateinit var info: UserInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        downloadUserInfo()
        setClickListeners()
        displayMessage()
    }

    private fun downloadUserInfo() {
        info = intent.getSerializableExtra("UserInfo") as UserInfo
    }

    private fun setClickListeners() {
        val emailText = "Email: ${info.eMail}"
        text_view_email.text = emailText

        val phoneText = "Phone: ${info.phoneNumber}"
        text_view_phone.text = phoneText

        text_view_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${info.eMail}")
            startActivity(intent)
        }

        text_view_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${info.phoneNumber}")
            startActivity(intent)
        }
    }

    private fun displayMessage() {
        val previewTextMessage = """
            Hi, ${info.firstName}!
            We are happy, that You joined 3MountainsExpeditions!
            Your knowledge about ${info.level} will be certainly significant for us.
            We are sure, that the name ${info.lastName} would be known on the top of every summit in the World!
            
            Please check if the info below are correct:
        """.trimIndent()

        text_view_message.text = previewTextMessage
    }
}