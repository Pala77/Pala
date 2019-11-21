package com.example.esmecalendar.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.esmecalendar.ItemClickListener
import com.example.esmecalendar.R
import com.example.esmecalendar.models.Event
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.event_item.view.*

class EventAdapter (val items : ArrayList<Event>,
                    val context: Context,
                    val itemClickListener: ItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_item, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0?.classTitle?.text = items.get(p1).title
        p0?.classroom?.text = items.get(p1).location
        p0?.prof?.text = items.get(p1).teacher
        p0?.date?.text = items.get(p1).date
        p0?.heure?.text = items.get(p1).time
        p0?.type?.text = items.get(p1).type

        p0.cardview.setOnClickListener {
            itemClickListener.onClickItem(items.get(p1))
        }

        p0.classroom.setOnClickListener {
            itemClickListener.onClickClassRoom(items.get(p1).location)
        }
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val classTitle = view.classTitle
    val classroom = view.classroom
    val prof = view.prof
    val date = view.date
    val heure = view.heure
    val type = view.type
    val cardview = view.cardview
    val image = view.image
}