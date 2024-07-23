package com.example.myapplication.ui.musica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MusicaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CancionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_musica, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val songs = resources.getStringArray(R.array.song_titles)
        adapter = CancionAdapter(songs)
        recyclerView.adapter = adapter

        return view
    }
}
