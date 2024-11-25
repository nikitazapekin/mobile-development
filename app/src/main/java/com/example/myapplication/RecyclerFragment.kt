package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SportsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = SportsAdapter(SportRepository.getSports()) { sport ->
            val detailFragment = DetailFragment.newInstance(sport)
            parentFragmentManager.beginTransaction()
          //      .replace(R.id.fragment_container, detailFragment)
                .replace(R.id.recyclerView, detailFragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

        return view
    }
}