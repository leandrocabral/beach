package br.com.leandroid.beachs

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import br.com.leandroid.beach.R
import br.com.leandroid.beachs.presentation.beach.BeachActivity

class MainActivity : AppCompatActivity() {

    lateinit var rotateAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rotateAnimation()
        closeSplashScreen()
    }

    private fun rotateAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
    }

    private fun closeSplashScreen() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, BeachActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}