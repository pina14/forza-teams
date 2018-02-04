package com.example.hugo.forzateams.view

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.hugo.forzateams.model.entities.Team
import android.view.LayoutInflater
import android.view.View
import com.example.hugo.forzateams.R
import com.example.hugo.forzateams.controller.App
import com.example.hugo.forzateams.controller.TeamActivity
import com.example.hugo.forzateams.view.holders.TeamListViewHolder

/**
 * Created by Hugo on 03/02/2018.
 */
class TeamsAdapter(val teamsList : ArrayList<Team>) : RecyclerView.Adapter<TeamListViewHolder>() {

    override fun getItemCount(): Int = teamsList.size

    /**
     * set view for item in position 'pos' on the list
     */
    override fun onBindViewHolder(holder: TeamListViewHolder, pos: Int) {
        val team = teamsList[pos]
        holder.teamNameTextView.text = team.teamName
        holder.teamCountryTextView.text = team.teamCountry
        holder.teamIsNationalTextView.visibility = if(team.isNationalTeam) View.VISIBLE else View.INVISIBLE

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, TeamActivity::class.java)
            intent.putExtra(App.teamExtra, teamsList[pos])
            it.context.startActivity(intent)
        }
    }

    /**
     * return ViewHolder inflated in view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.team_row, parent, false)

        return TeamListViewHolder(itemView)
    }
}