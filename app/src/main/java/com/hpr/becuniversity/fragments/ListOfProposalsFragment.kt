package com.hpr.becuniversity.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import com.hpr.becuniversity.AnalyzeProposalActivity
import com.hpr.becuniversity.MainActivity

import com.hpr.becuniversity.R
import kotlinx.android.synthetic.main.fragment_list_of_proposals.*
import kotlinx.android.synthetic.main.fragment_list_of_proposals.view.*
import kotlinx.android.synthetic.main.fragment_main_home.view.*

private const val ARG_PARAM1 = "param1"

class ListOfProposalsFragment : Fragment() {
    private var param1: String? = null
    private var listener: OnFragmentListProposalsListener? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }


    }

    @SuppressLint("RestrictedApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_list_of_proposals, container, false)

        view.cvItemProposal.setOnClickListener { v ->
            Log.i("TAG", "sjhjshfd")
            openActivity(AnalyzeProposalActivity::class.java)
        }

        hasOptionsMenu()

        return view
    }

    private fun openActivity(mActivity: Class<AnalyzeProposalActivity>) {
        var mIntent = Intent(activity, mActivity)
        var apc = ActivityOptionsCompat.makeSceneTransitionAnimation(activity!!, cvItemProposal, getString(R.string.transaction_key_item_main))
        ActivityCompat.startActivity(activity!!, mIntent, apc.toBundle())
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListProposalsListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentListProposalsListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentListProposalsListener {
        fun onFragmentListProposalsApi(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
                ListOfProposalsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                    }
                }
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.main_menu, menu!!)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id = item!!.itemId
        when(id){
            android.R.id.home -> {
                Log.i("TAG", "fragment home navigation")
                (listener as MainActivity).mPopBackStack()
                (listener as MainActivity).mIconHomeHasEnable(false)
            }

        }

        return super.onOptionsItemSelected(item)
    }
}
