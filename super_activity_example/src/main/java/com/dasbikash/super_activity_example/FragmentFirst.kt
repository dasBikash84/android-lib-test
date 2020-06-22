package com.dasbikash.super_activity_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dasbikash.super_activity.SingleFragmentSuperActivity
import kotlinx.android.synthetic.main.fragment_fragment_first.*

class FragmentFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launch_2.setOnClickListener {
            (activity as SingleFragmentSuperActivity).addFragment(FragmentSecond())
        }
        clear_and_launch_2.setOnClickListener {
            (activity as SingleFragmentSuperActivity).addFragmentClearingBackStack(FragmentSecond())
        }

    }
}