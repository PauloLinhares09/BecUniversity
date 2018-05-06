package com.hpr.becuniversity

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import com.hpr.becuniversity.fragments.ListOfProposalsFragment
import com.hpr.becuniversity.fragments.MainHomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainHomeFragment.OnFragmentMainHomeListener, ListOfProposalsFragment.OnFragmentListProposalsListener, FragmentManager.OnBackStackChangedListener {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                message.setText(R.string.enables)

                mReplaceFragment(MainHomeFragment.newInstance(""), MainHomeFragment::class.java.simpleName)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
//                message.setText(R.string.in_run)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.done)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.addOnBackStackChangedListener(this)

        mReplaceFragment(MainHomeFragment.newInstance(""), MainHomeFragment::class.java.simpleName)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    override fun onResume() {
        super.onResume()
        mIconHomeHasEnable(false)
    }


    fun mReplaceFragment(fragment: Fragment, flag :  String) {
//        if (flag.equals(ListOfProposalsFragment::class.java.simpleName, true)){
//            mIconHomeHasEnable(true)
//        }

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container_fragment, fragment, flag)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun mPopBackStack(){
        supportFragmentManager.popBackStack()
    }

    fun mIconHomeHasEnable(enable: Boolean){
        supportActionBar!!.setDisplayHomeAsUpEnabled(enable)
    }

//    private fun openActivity(mActivity: Class<AnalyzeProposalActivity>) {
//        var mIntent = Intent(this, mActivity)
//        var apc = ActivityOptionsCompat.makeSceneTransitionAnimation(this, cvItem, getString(R.string.transaction_key_item_main))
//        ActivityCompat.startActivity(this, mIntent, apc.toBundle())
//    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item!!.itemId
        when(id){
            android.R.id.home ->{
                Log.i("TAG", "home namvigation")
                //mPopBackStack()
                onBackPressed()
            }


        }

        return super.onOptionsItemSelected(item)
    }

    override fun onFragmentMainHomeApi(uri: Uri) {

    }

    override fun onFragmentListProposalsApi(uri: Uri) {

    }


    fun shouldDisplayHomeUp() {
        //Enable Up button only  if there are entries in the back stack
        val canback = supportFragmentManager.backStackEntryCount > 1
        supportActionBar!!.setDisplayHomeAsUpEnabled(canback)
    }

    override fun onBackStackChanged() {
        shouldDisplayHomeUp()
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 1) {
            super.onBackPressed()
        }else{
            finish()
        }
    }
}
