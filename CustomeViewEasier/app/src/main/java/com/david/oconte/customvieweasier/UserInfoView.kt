package com.david.oconte.customvieweasier

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources

class UserInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout (context, attrs, defStyle, defStyleRes){

    private var logoView : ImageView
    private var usernameView : TextView
    private var levelView : TextView

    var username: String = ""
        set(value) {
            field = value
            usernameView.text = value
        }

    var level: String = ""
        set(value) {
            field = value
            levelView.text = value
        }

    var logo: Drawable? = null
        set(value) {
            field = value
            value?.let {
                logoView.setImageDrawable(it)
            }
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this, true)
        orientation = VERTICAL

        //get view we will add data for
        logoView = findViewById(R.id.logo)
        usernameView = findViewById(R.id.username)
        levelView = findViewById(R.id.level)

        // Fill views with custom attributes
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.UserInfoView)

            username = resources.getText(typedArray.getResourceId(R.styleable.UserInfoView_username, R.string.defaultString)).toString()
            level = resources.getText(typedArray.getResourceId(R.styleable.UserInfoView_level, R.string.defaultString)).toString()
            val logoRes = typedArray.getResourceId(R.styleable.UserInfoView_logoRef,-1)
            if (logoRes != -1) {
                logo = AppCompatResources.getDrawable(context, logoRes)
            }

            typedArray.recycle()

        }

    }

}