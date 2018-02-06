package com.example.hugo.forzateams

import com.example.hugo.forzateams.model.entities.Team
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Test

import org.junit.Assert.*

class JsonTeamParseTest {
    val gson = Gson()

    @Test
    fun json_array_isEmpty() {
        val json = "[]"
        val teams = gson.fromJson<ArrayList<Team>>(json, object : TypeToken<ArrayList<Team>>() {}.type)
        assertEquals(0, teams.size)
    }

    @Test
    fun json_array_oneElement() {
        val json = "[\n" +
                "    {\n" +
                "        \"name\": \"Arsenal FC\",\n" +
                "        \"national\": false,\n" +
                "        \"country_name\": \"England\"\n" +
                "    }" +
                "]"
        val teams = gson.fromJson<ArrayList<Team>>(json, object : TypeToken<ArrayList<Team>>() {}.type)
        assertEquals(1, teams.size)
        assertEquals("Arsenal FC", teams[0].teamName)
        assertEquals(false, teams[0].isNationalTeam)
        assertEquals("England", teams[0].teamCountry)
    }

    @Test
    fun json_array_multipleElements() {
        val json = "[\n" +
                "    {\n" +
                "        \"name\": \"Arsenal FC\",\n" +
                "        \"national\": false,\n" +
                "        \"country_name\": \"England\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"FC Barcelona\",\n" +
                "        \"national\": false,\n" +
                "        \"country_name\": \"Spain\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Sweden\",\n" +
                "        \"national\": true,\n" +
                "        \"country_name\": \"Sweden\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Inter Milan\",\n" +
                "        \"national\": false,\n" +
                "        \"country_name\": \"Italy\"\n" +
                "    }\n" +
                "]"

        val teams = gson.fromJson<ArrayList<Team>>(json, object : TypeToken<ArrayList<Team>>() {}.type)
        assertEquals(4, teams.size)
        //first team
        assertEquals("Arsenal FC", teams[0].teamName)
        assertEquals(false, teams[0].isNationalTeam)
        assertEquals("England", teams[0].teamCountry)
        //second team
        assertEquals("FC Barcelona", teams[1].teamName)
        assertEquals(false, teams[1].isNationalTeam)
        assertEquals("Spain", teams[1].teamCountry)
        //third team
        assertEquals("Sweden", teams[2].teamName)
        assertEquals(true, teams[2].isNationalTeam)
        assertEquals("Sweden", teams[2].teamCountry)
        //fourth team
        assertEquals("Inter Milan", teams[3].teamName)
        assertEquals(false, teams[3].isNationalTeam)
        assertEquals("Italy", teams[3].teamCountry)
    }

}
