package com.example.esmecalendar

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.esmecalendar.adapters.EventAdapter
import com.example.esmecalendar.interfaces.IEventInterface
import com.example.esmecalendar.mocks.EventsMock
import com.example.esmecalendar.models.Event
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {


    var eventsRepository: IEventInterface = EventsMock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_event_list.layoutManager = LinearLayoutManager(this)
        getEventsInThread()
        val btnOpenActivity : Button = findViewById(R.id.button)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this,Main3Activity :: class.java)
            startActivity(intent)
        }

        val btnOpenActivity2 : Button = findViewById(R.id.button2)
        btnOpenActivity2.setOnClickListener {
            val intent = Intent(this,Main2Activity :: class.java)
            startActivity(intent)
        }
    }

    fun getEventsInThread() {

        val thread = Thread(
            Runnable {
                showProgress()
                showEvents(eventsRepository.getEvents(), applicationContext)
            }
        )

        thread.start()
    }

    fun showEvents(events: ArrayList<Event>, context: Context) {

        //runUIThread

        runOnUiThread {
            //Affiche les evenement du calendrier
            rv_event_list.adapter = EventAdapter(events, context,this)
            //cache la progression
            hideProgress()
        }


    }

    fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }


    override fun onClickItem(event :Event){

        val intent = Intent(applicationContext, ChatActivity::class.java)

        intent.putExtra("EVENT", event.id)

        startActivity(intent)

        Toast.makeText(applicationContext,"Interface marche",Toast.LENGTH_SHORT).show()
    }

    override fun onClickClassRoom(classroom: String) {
        val intent = Intent(applicationContext, LocationActivity::class.java)

        startActivity(intent)
        Toast.makeText(applicationContext,"Class"+classroom,Toast.LENGTH_SHORT).show()
    }

}

interface ItemClickListener{
    fun onClickItem(event :Event)
    fun onClickClassRoom(classroom : String)
}