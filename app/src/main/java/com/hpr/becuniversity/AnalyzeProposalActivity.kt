package com.hpr.becuniversity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.Window

import kotlinx.android.synthetic.main.activity_analyze_proposal.*
import android.support.design.widget.TabLayout
import android.view.View
import com.hpr.becuniversity.adapters.PageAdapterAnalyzeActivity


class AnalyzeProposalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyze_proposal)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //view pager and tabs
        // Add Fragments to adapter one by one

        val adapter = PageAdapterAnalyzeActivity(supportFragmentManager)
        pager.setAdapter(adapter)

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(pager)


        //Floating
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item!!.itemId
        when(id){
           android.R.id.home ->
                   supportFinishAfterTransition()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
    }



}
