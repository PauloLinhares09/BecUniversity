package com.hpr.becuniversity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.hpr.becuniversity.adapters.StepAdapter
import com.hpr.becuniversity.adapters.ViewPagerMainAdapter
import com.hpr.becuniversity.fragments.CheckVoteFragment1
import com.hpr.becuniversity.fragments.CheckVoteFragment2
import com.hpr.becuniversity.fragments.CheckVoteFragment3
import com.hpr.becuniversity.models.StepPregao

import kotlinx.android.synthetic.main.activity_check_vote.*

class CheckVoteActivity : AppCompatActivity(), FlowChekVote {

    private  var adapter_step: StepAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_vote)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        initViews()

    }

    private fun initViews() {

        view_pager



        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerview_step.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false)

        var lista_step = ArrayList<StepPregao>()
        lista_step.add(StepPregao("Superfatiramento",true))
        lista_step.add(StepPregao("Qualificações"))
        lista_step.add(StepPregao("Pregoeiro"))

        adapter_step = StepAdapter(lista_step,this)

        adapter_step?.listern = object : StepAdapter.StepSelectedListern{
            override fun stepSelected(position: Int) {
                (recyclerview_step.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(position, 4)
                view_pager.currentItem = position
            }

        }

        recyclerview_step.adapter = adapter_step


        view_pager.setOnPageChangeListener( object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {


            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                adapter_step?.selecionar(position)
                (recyclerview_step.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(position, 4)
            }

        })

        val adapter_frag = ViewPagerMainAdapter(supportFragmentManager)

        adapter_frag.addFragment(CheckVoteFragment1(), "")
        adapter_frag.addFragment(CheckVoteFragment2(), "")
        adapter_frag.addFragment(CheckVoteFragment3(), "")

        view_pager.adapter = adapter_frag
    }

    override fun nextStep() {

        if (view_pager.currentItem < 2) {
            view_pager.currentItem = view_pager.currentItem + 1
        }else{
            startActivity(Intent(this, FinalScoreActivity::class.java))
        }
    }


}
interface FlowChekVote{
    fun nextStep()
}