package com.hpr.becuniversity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.hpr.becuniversity.adapters.StepAdapter
import com.hpr.becuniversity.models.StepPregao

import kotlinx.android.synthetic.main.activity_check_vote.*

class CheckVoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_vote)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerview_step.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false)

        var lista_step = ArrayList<StepPregao>()
        lista_step.add(StepPregao("Proposta",true))
        lista_step.add(StepPregao("Abertura C. Pública"))
        lista_step.add(StepPregao("Classificação"))
        lista_step.add(StepPregao("Lances"))
        lista_step.add(StepPregao("Negocioação"))
        lista_step.add(StepPregao("Habilitação"))
        lista_step.add(StepPregao("Recurso"))
        lista_step.add(StepPregao("Encerrado"))

        var adapter = StepAdapter(lista_step,this)

        recyclerview_step.adapter = adapter
    }

}
