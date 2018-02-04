package com.example.hugo.forzateams.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.android.volley.Request
import com.example.hugo.forzateams.R
import com.example.hugo.forzateams.model.CustomRequest
import com.example.hugo.forzateams.model.responseListeners.TeamsResponseListener
import com.example.hugo.forzateams.model.entities.Team
import com.example.hugo.forzateams.view.TeamsAdapter
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    companion object {
        val forzaUrl = "https://s3-eu-west-1.amazonaws.com/forza-assignment/android/teams.json"
    }

    private val teamsList = ArrayList<Team>()
    private lateinit var recyclerView : RecyclerView
    private lateinit var teamsAdapter : TeamsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initiate recycler and its properties
        setupRecycler()

        //make request to server
        val teamsListener = TeamsResponseListener(this, teamsAdapter)
        val req = CustomRequest(Request.Method.GET,
                forzaUrl,
                object : TypeToken<ArrayList<Team>>() {}.type,
                teamsListener,
                teamsListener)
        App.requestQueue.add(req)
    }

    private fun setupRecycler() {
        recyclerView = teams_recycler_view
        teamsAdapter = TeamsAdapter(teamsList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))   //set separator line between items
        recyclerView.adapter = teamsAdapter
    }
}
