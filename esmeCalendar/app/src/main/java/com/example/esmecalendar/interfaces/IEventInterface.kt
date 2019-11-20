package com.example.esmecalendar.interfaces

import com.example.esmecalendar.models.Event


interface IEventInterface {
    fun getEvents():ArrayList<Event>
 //   getwifiList();
 //   getWIFIPower(); //97.4
 //   get position from wifi List >t();

    // à faire un tableau convertisseur qui nous renvois dans la salle : Convertisseur [w1 : 97.4, W2: 86.4, W3: 5] => M17

}