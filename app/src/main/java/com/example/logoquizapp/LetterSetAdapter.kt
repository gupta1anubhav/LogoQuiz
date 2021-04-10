package com.example.logoquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LetterSetAdapter(val context: Context?, private var possibleLetterSet: List<Char>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LetterSetViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.possible_letter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? LetterSetViewHolder)?.tv?.text = possibleLetterSet?.get(position).toString()
    }

    override fun getItemCount(): Int {
        return possibleLetterSet?.size ?: 0
    }

    inner class LetterSetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv: TextView = itemView.findViewById(R.id.tv)
    }

    interface LogoInteraction {
        // we can use this to remove character from adapter list
        fun onLetterClick(position: Int)
    }
}