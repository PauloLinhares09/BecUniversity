package com.hpr.becuniversity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.Window

import kotlinx.android.synthetic.main.activity_analyze_proposal.*
import android.support.design.widget.TabLayout
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.hpr.becuniversity.adapters.PageAdapterAnalyzeActivity
import kotlinx.android.synthetic.main.content_activity_analyze_proposal.*


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
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            //openActivity(CheckVoteActivity::class.java)
            startActivity(Intent(this@AnalyzeProposalActivity,CheckVoteActivity::class.java))
        }
    }

    private fun openActivity(mActivity: Class<CheckVoteActivity>) {
        var mIntent = Intent(this, mActivity)
        var apc = ActivityOptionsCompat.makeSceneTransitionAnimation(this, cvItem, getString(R.string.transaction_key_item_main))
        ActivityCompat.startActivity(this, mIntent, apc.toBundle())
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
