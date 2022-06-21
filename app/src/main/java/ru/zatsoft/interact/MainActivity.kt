package ru.zatsoft.interact

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView
import ru.zatsoft.interact.utils.StatsView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clipDuration = 10000L

        val button = findViewById<Button>(R.id.btnPlay)
        button.setOnClickListener {
             println("fire!")
        }

        val textLeft = findViewById<TextView>(R.id.textLeft)
        val textRight = findViewById<TextView>(R.id.textRight)

        val valueAnimator = ValueAnimator.ofInt(100, 0)
        valueAnimator.duration = clipDuration
        valueAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Int
            textLeft.text = animatedValue.toString()
            textRight.text = animatedValue.toString()
        }
        valueAnimator.start()

        val animation = TranslateAnimation(-40f, 750f, 0f, 0f)
        animation.duration = clipDuration
        animation.fillAfter = true
        button.startAnimation(animation)


    }
}

