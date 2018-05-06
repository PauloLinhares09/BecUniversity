package com.hpr.becuniversity.adapters

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpr.becuniversity.R
import com.hpr.becuniversity.models.StepPregao
import kotlinx.android.synthetic.main.item_etapa.view.*

/**
 * Created by dev on 25/10/17.
 */
class StepAdapter(var mlista: List<StepPregao>,
                  val context: Context) : RecyclerView.Adapter<StepAdapter.MyViewHolder>(){

    var listern: StepSelectedListern? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_etapa, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



        with(mlista[position]){
            holder.itemView?.textview_step?.text = name

            if (selected){
                holder.itemView?.textview_step?.setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent))
                holder.itemView?.view_ponta?.background = ContextCompat.getDrawable(context,R.drawable.ic_triangle_redy)
            }else{
                holder.itemView?.textview_step?.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimaryDark))
                holder.itemView?.view_ponta?.background = ContextCompat.getDrawable(context,R.drawable.ic_triangle_gray)

            }

        }

        if (position < mlista.size - 1) {

            val step_next = mlista[position + 1]

            if (step_next.selected) {
                holder.itemView?.ll_step?.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
            } else {
                holder.itemView?.ll_step?.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            }

        }else{
            holder.itemView?.ll_step?.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.itemView?.setOnClickListener {
            selecionar(position)
            listern?.stepSelected(position)
        }

    }

    private fun selecionar(position: Int) {
        var i = 0
        for (StepPregao in mlista){

            if (mlista[i].selected){
                mlista[i].selected = false
            }

            i++
        }

        mlista.get(position).selected = true

        notifyDataSetChanged()
    }

    fun replaceData(books:List<StepPregao>){

        mlista = books
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return mlista.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface StepSelectedListern{
        fun stepSelected(position: Int)
    }
}