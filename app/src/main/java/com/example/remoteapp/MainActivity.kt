package com.example.remoteapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val firebaseRemoteInstance = FirebaseRemoteConfig.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        firebaseRemoteInstance.fetch(0)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    firebaseRemoteInstance.fetchAndActivate()
                }
                tv_message.text = firebaseRemoteInstance.getString("message")
                tv_message.setTextColor(
                    Color.parseColor(
                        firebaseRemoteInstance.getString("ColorCode").replace("\\s".toRegex(), "")
                    )
                )
                tv_message.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    firebaseRemoteInstance.getString("TextSize").toFloat()
                )
                tv_version.text="Version "+firebaseRemoteInstance.getString("App_Version")
            }
    }
}