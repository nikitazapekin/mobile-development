package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class ListViewFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var sportsAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_view, container, false)
        listView = view.findViewById(R.id.listView)

        val sports = SportRepository.getSports().map { it.name }
        sportsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, sports)
        listView.adapter = sportsAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), "Вы выбрали: ${sports[position]}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}