package com.hpr.becuniversity.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import com.hpr.becuniversity.FlowChekVote

import com.hpr.becuniversity.R
import kotlinx.android.synthetic.main.content_check_vote_0.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CheckVoteFragment1 : Fragment() {

    private var listern: FlowChekVote? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_vote_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        rgChecksVote.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

                listern?.nextStep()
            }

        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FlowChekVote) {
            listern = context as FlowChekVote
        } else {
            throw ClassCastException()
        }
    }


}
