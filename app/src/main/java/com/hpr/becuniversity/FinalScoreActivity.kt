package com.hpr.becuniversity

import android.content.Intent
import android.os.Bundle
import android.support.animation.SpringAnimation
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_final_score.*
import android.support.animation.SpringForce
import com.hpr.becuniversity.R.id.toolbar
import kotlinx.android.synthetic.main.content_final_score.*


class FinalScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_score)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item!!.itemId

        when(id){
            android.R.id.home ->
                    navigateUpTo(Intent(this, MainActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        var springY = SpringAnimation(llScoreValue, SpringAnimation.ROTATION_Y, 0f)

        val springForceX = SpringForce()
        springForceX.stiffness = SpringForce.STIFFNESS_MEDIUM
        springForceX.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        springY.setSpring(springForceX)
        springY.start()

    }

}
