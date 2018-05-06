package com.hpr.becuniversity.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpr.becuniversity.MainActivity

import com.hpr.becuniversity.R
import kotlinx.android.synthetic.main.fragment_main_home.view.*

private const val ARG_PARAM1 = "param1"

class MainHomeFragment : Fragment() {
    private var param1: String? = null
    private var listener: OnFragmentMainHomeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_home, container, false)

        view.cvItem.setOnClickListener { v ->
            Log.i("TAG", "sjhjshfd")
//            openActivity(AnalyzeProposalActivity::class.java)
            var fragment = ListOfProposalsFragment.newInstance("")
            (listener as MainActivity).mReplaceFragment(fragment, ListOfProposalsFragment::class.java.simpleName)
        }

        return view
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentMainHomeListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentMainHomeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentMainHomeListener {
        // TODO: Update argument type and name
        fun onFragmentMainHomeApi(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
                MainHomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }
    }
}
