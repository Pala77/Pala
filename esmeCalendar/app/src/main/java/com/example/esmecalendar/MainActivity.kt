package com.example.esmecalendar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
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
        Toast.makeText(applicationContext,"Interface marche",Toast.LENGTH_SHORT).show()
    }

}

interface ItemClickListener{
    fun onClickItem(event :Event)
}
