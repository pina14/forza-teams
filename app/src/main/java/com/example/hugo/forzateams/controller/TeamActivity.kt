package com.example.hugo.forzateams.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hugo.forzateams.R
import com.example.hugo.forzateams.model.entities.Team

import kotlinx.android.synthetic.main.activity_team.*
import kotlinx.android.synthetic.main.content_team.*

class TeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val team = intent.extras.get(App.teamExtra) as Team

        //set team name
        team_name.text = team.teamName

        //set different image and description for national and non-national teams
        val image : Int
        if(team.isNationalTeam){
            image =  R.drawable.flags
            team_description.text = getString(R.string.national_team_description, team.teamCountry)
        } else {
            image = R.drawable.leagues
            team_description.text = getString(R.string.non_national_team_description, team.teamName, team.teamCountry)
        }
        team_background_image.setImageResource(image)
    }

}
