package com.example.hugo.forzateams.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.team_row.view.*

/**
 * Created by Hugo on 03/02/2018.
 */
class TeamListViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val teamNameTextView : TextView = view.team_name_text
    val teamCountryTextView : TextView = view.team_description
    val teamIsNationalTextView : ImageView = view.is_national_image

}