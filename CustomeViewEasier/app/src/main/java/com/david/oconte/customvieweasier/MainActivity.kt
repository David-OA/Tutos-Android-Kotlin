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
        meInfo.logo = AppCompatResources.getDrawable(this, R.drawable.my_info_foreground)

        val friendInfo = findViewById<UserInfoView>(R.id.friendInfo)
        friendInfo.username = "myFriend"
        friendInfo.level = "Maitre du monde"
        friendInfo.logo = AppCompatResources.getDrawable(this, R.drawable.my_friend_foreground)
    }
}