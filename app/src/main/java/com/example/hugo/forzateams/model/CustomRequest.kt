package com.example.hugo.forzateams.model

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.ParseError
import com.google.gson.JsonSyntaxException
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * Created by Hugo on 02/02/2018.
 */
class CustomRequest<T>(reqMethod : Int, private val reqUrl : String, val type: Type, private val listener : Response.Listener<T>, errorListener : Response.ErrorListener) : Request<T>(reqMethod, reqUrl, errorListener) {

    companion object {
        val gson = Gson()
    }

    override fun parseNetworkResponse(response: NetworkResponse): Response<T> {
        try {
            val json = String(response.data)
            return Response.success(
                    gson.fromJson(json, type),
                    HttpHeaderParser.parseCacheHeaders(response))
        } catch (e: JsonSyntaxException) {
            return Response.error<T>(ParseError(e))
        }
    }

    override fun deliverResponse(response: T) {
        listener.onResponse(response)
    }
}