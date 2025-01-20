package com.example.messfood

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.xml.activity_splash)

        // Get the LottieAnimationView from the layout
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie_animation)

        // Optional: Set animation programmatically (if not set in XML)
        lottieAnimationView.setAnimation(R.raw.splash_screen_animation)

        lottieAnimationView.playAnimation()

        // Wait for animation to complete or add a fixed delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish SplashActivity to prevent going back to it
        }, 6000) // Adjust delay to match animation duration or desired splash screen time
    }
}
