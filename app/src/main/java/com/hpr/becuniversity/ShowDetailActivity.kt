package com.hpr.becuniversity

import android.os.Bundle
import android.app.Activity
import android.view.Menu
import android.view.MenuItem
import android.view.Window

import kotlinx.android.synthetic.main.activity_show_detail.*

class ShowDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

}
