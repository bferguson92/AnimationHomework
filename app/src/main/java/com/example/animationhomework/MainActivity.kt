package com.example.animationhomework

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bugDroid.setOnClickListener{view->
            val size: Float = (Math.random() * 8 + 1).toFloat()

            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, size)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, size)
            val animation = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY)

            animation.repeatCount = 1
            animation.repeatMode = ObjectAnimator.REVERSE
            animation.duration = (Math.random() * 1000 + 500).toLong()

            animation.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    bugDroid.isClickable = false
                }

                override fun onAnimationEnd(animation: Animator?) {
                    bugDroid.isClickable = true
                }
            })

            animation.start()
        }
    }
}
