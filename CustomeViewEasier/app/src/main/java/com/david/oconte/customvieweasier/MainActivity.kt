package com.david.oconte.customvieweasier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  meInfo = findViewById<UserInfoView>(R.id.meInfo)
        meInfo.username = "myUserName"
        meInfo.level = "Grand master"
        meInfo.logo = AppCompatResources.getDrawable(this, R.drawable.ic_launcher_foreground)
    }
}