package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class SportsAdapter(
    private val sports: List<OlympicSport>,
    private val onClick: (OlympicSport) -> Unit
) : RecyclerView.Adapter<SportsAdapter.SportViewHolder>() {

    class SportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.sportName)
        val year: TextView = view.findViewById(R.id.sportYear)
        val type: TextView = view.findViewById(R.id.sportType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sport, parent, false)
        return SportViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val sport = sports[position]
        holder.name.text = sport.name
        holder.year.text = sport.yearRecognized.toString()
        holder.type.text = if (sport.isTeam) "Командный" else "Одиночный"

        holder.itemView.setOnClickListener { onClick(sport) }
    }

    override fun getItemCount(): Int = sports.size
}