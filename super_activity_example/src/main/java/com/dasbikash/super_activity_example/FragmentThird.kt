package com.dasbikash.super_activity_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dasbikash.pop_up_message.showShortSnack
import kotlinx.android.synthetic.main.fragment_fragment_third.*


class FragmentThird : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch_4.setOnClickListener {
            showShortSnack("No more forward screen!!")
        }
        clear_and_launch_4.setOnClickListener {
            showShortSnack("No more forward screen!!")
        }
    }
}