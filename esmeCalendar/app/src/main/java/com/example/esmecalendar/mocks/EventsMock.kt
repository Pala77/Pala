package com.example.esmecalendar.mocks

import android.provider.CalendarContract
import com.example.esmecalendar.interfaces.IEventInterface
import com.example.esmecalendar.models.Event
import com.example.esmecalendar.models.Events
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EventsMock : IEventInterface {


    override fun getEvents(): ArrayList<Event> {

        //tempo
        Thread.sleep(3000)

    /*    val listEvent = arrayListOf<Event>()


        listEvent.add(
            Event(
                "1",
                "VHDL",
                "Samedi",
                "8h30",
                "Cours",
                "M17",
                "Floquet",
                "https://upload.wikimedia.org/wikipedia/commons/b/be/Esme-sudria-logo.png",
                ""
            )
        )*/

        return getEventsFromJSON(apiResponse)
    }

    fun getEventsFromJSON(json: String): ArrayList<Event> {

       return Gson().fromJson<Events>(json, Events::class.java).events

    }


    val apiResponse = "{\n" +
            "\"events\": [\n" +
            "{\n" +
            "\"id\":\"1\",\n" +
            "\"title\" : \"VHDL\",\n" +
            "\"date\":\"6/11/19\",\n" +
            "\"heure\":\"8h30\",\n" +
            "\"type\":\"Cours\",\n" +
            "\"location\":\"M17\",\n" +
            "\"url\":\"\",\n" +
            "\"information\":\"super cours\"\n" +
            "},\n" +
            "{\n" +
            "\"id\":\"1\",\n" +
            "\"title\" : \"VHDL\",\n" +
            "\"date\":\"6/11/19\",\n" +
            "\"heure\":\"8h30\",\n" +
            "\"type\":\"Cours\",\n" +
            "\"location\":\"M18\",\n" +
            "\"url\":\"\",\n" +
            "\"information\":\"super cours\"\n" +
            "}\n" +
            "]\n" +
            "}"


}