package com.example.hugo.forzateams.controller

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by Hugo on 03/02/2018.
 */
class App : Application(){

    companion object {
        @Volatile lateinit var requestQueue : RequestQueue
        val teamExtra = "team"
    }

    override fun onCreate() {
        super.onCreate()
        requestQueue = Volley.newRequestQueue(this)
    }
}