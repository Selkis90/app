package com.example.myapplication.ui.musica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import androidx.recyclerview.widget.RecyclerView


class MusicaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_musica, container, false)

        // Initialize RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Get the list of songs from resources
        val songTitles = resources.getStringArray(R.array.song_titles).toList()

        // Set the adapter
        recyclerView.adapter = SongAdapter(songTitles)

        return view
    }
}
