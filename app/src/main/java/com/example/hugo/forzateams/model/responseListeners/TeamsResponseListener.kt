package com.example.hugo.forzateams.model.responseListeners

import android.content.Context
import com.android.volley.Response
import com.example.hugo.forzateams.model.entities.Team
import com.example.hugo.forzateams.view.TeamsAdapter

/**
 * Created by Hugo on 02/02/2018.
 */
class TeamsResponseListener(ctx : Context, private val adapter : TeamsAdapter) :  ResponseListener(ctx), Response.Listener<ArrayList<Team>> {

    override fun onResponse(response: ArrayList<Team>) {
        val beginning = adapter.itemCount
        adapter.teamsList.addAll(response)

        adapter.notifyItemRangeInserted(beginning, response.size)
    }
}