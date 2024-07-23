package com.example.myapplication.ui.musica

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCancionBinding

class CancionAdapter(private val songs: Array<String>) :
    RecyclerView.Adapter<CancionAdapter.CancionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        val binding = ItemCancionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CancionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    override fun getItemCount(): Int = songs.size

    class CancionViewHolder(private val binding: ItemCancionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(songTitle: String) {
            binding.songTitle.text = songTitle
        }
    }
}
