package com.example.hugo.forzateams.model.responseListeners

import android.content.Context
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.VolleyError

/**
 * Created by Hugo on 02/02/2018.
 */
open class ResponseListener(private val ctx : Context) : Response.ErrorListener {
    override fun onErrorResponse(error: VolleyError?) {
        Toast.makeText(ctx, "Error on making request!", Toast.LENGTH_LONG).show()
    }
}