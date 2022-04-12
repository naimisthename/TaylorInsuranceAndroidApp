package com.malkinfo.loginpageui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUp.setOnClickListener {
            signUp.background = resources.getDrawable(R.drawable.switch_trcks,null)
            signUp.setTextColor(resources.getColor(R.color.textColor,null))
            logIn.background = null
            signUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.logoColor,null))
        }
        logIn.setOnClickListener {
            signUp.background = null
            signUp.setTextColor(resources.getColor(R.color.logoColor,null))
            logIn.background = resources.getDrawable(R.drawable.switch_trcks,null)
            signUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.textColor,null))
        }
        signIn.setOnClickListener {
            startActivity(Intent(this@MainActivity,NewActivity::class.java))
        }

        // get reference to ImageView
        val aboutUs = findViewById(R.id.aboutUs) as ImageView
        // set on-click listener for ImageView
        aboutUs.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

        // get reference to ImageView
        val contactUs = findViewById(R.id.contactUs) as ImageView
        // set on-click listener for ImageView
        contactUs.setOnClickListener{
            val intent = Intent(this, ContactUs::class.java)
            startActivity(intent)
        }

        // get reference to ImageView
        val tipsTricks = findViewById(R.id.tipsTricks) as ImageView
        // set on-click listener for ImageView
        tipsTricks.setOnClickListener {
            val intent = Intent(this, TipsAndTricks::class.java)
            startActivity(intent)


        }

    }
}


