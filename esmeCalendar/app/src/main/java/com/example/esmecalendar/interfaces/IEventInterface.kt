package com.example.esmecalendar.interfaces

import com.example.esmecalendar.models.Event


interface IEventInterface {
    fun getEvents():ArrayList<Event>
}