package com.hpr.becuniversity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MainActivity::class.java)
        //Intent intent = new Intent(this, TesteFavoritoHistorico.class);
        startActivity(intent)
        finish()
    }
}
