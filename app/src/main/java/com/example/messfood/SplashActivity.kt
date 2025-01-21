package com.example.messfood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.xml.activity_splash)

        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie_animation)

        lottieAnimationView.setAnimation(R.raw.new_splash_screen_animation)

        lottieAnimationView.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3125)
    }
}