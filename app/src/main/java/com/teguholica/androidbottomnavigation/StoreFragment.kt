package com.teguholica.androidbottomnavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.toolbox.JsonArrayRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_store.view.*


/**
 * Created by teguholica on 10/01/18.
 * Store List
 */

class StoreFragment: Fragment() {

    private val movieList: MutableList<Movie> = emptyList<Movie>().toMutableList()
    private val adapter: StoreAdapter = StoreAdapter(movieList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_store, container, false)

        with(view) {
            vList.layoutManager = GridLayoutManager(context, 3)
            vList.itemAnimator = DefaultItemAnimator()
            vList.adapter = adapter
            vList.isNestedScrollingEnabled = false
        }

        fetchStoreItems()

        return view
    }

    private fun fetchStoreItems() {
        val request = JsonArrayRequest("https://api.androidhive.info/json/movies_2017.json", {
            Log.d("test", "success")
            if (it == null) {
                Toast.makeText(context, "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show()
            }

//            val items = Gson().fromJson<List<Movie>>(it.toString(), Movie::class.java)

            val items = Gson().fromJson<List<Movie>>(it.toString(), object : TypeToken<List<Movie>>() {}.type)

            movieList.clear()
            movieList.addAll(items)

            adapter.notifyDataSetChanged()
        }, {
            Log.d("test", "fail")
            Toast.makeText(context, "Error: " + it.message, Toast.LENGTH_SHORT).show()
        })

        App.instance.addToRequestQueue(request)
    }

}