package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.myapplication.R

class DetailFragment : Fragment() {
    private lateinit var sport: OlympicSport

    companion object {
        fun newInstance(sport: OlympicSport): DetailFragment {
            val fragment = DetailFragment()
            fragment.sport = sport
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val nameTextView: TextView = view.findViewById(R.id.sportName)
        val typeTextView: TextView = view.findViewById(R.id.sportType)
        val yearTextView: TextView = view.findViewById(R.id.sportYear)

        nameTextView.text = sport.name
        typeTextView.text = if (sport.isTeam) "Командный" else "Одиночный"
        yearTextView.text = sport.yearRecognized.toString()

        return view
    }
}