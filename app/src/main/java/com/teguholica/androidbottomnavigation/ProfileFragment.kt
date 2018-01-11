package com.teguholica.androidbottomnavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment.view.*

/**
 * Created by teguholica on 10/01/18.
 * Profile Page
 */

class ProfileFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)

        with(view) {
            txtLabel.text = "Profile Fragment"
        }

        return view
    }

}
