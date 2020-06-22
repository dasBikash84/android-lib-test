package com.dasbikash.super_activity_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dasbikash.super_activity.SingleFragmentSuperActivity
import kotlinx.android.synthetic.main.fragment_fragment_second.*


class FragmentSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch_3.setOnClickListener {
            (activity as SingleFragmentSuperActivity).addFragment(FragmentThird())
        }
        clear_and_launch_3.setOnClickListener {
            (activity as SingleFragmentSuperActivity).addFragmentClearingBackStack(FragmentThird())
        }
    }
}