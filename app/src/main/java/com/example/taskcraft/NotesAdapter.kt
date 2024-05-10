package com.example.taskcraft

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes: List<Note>, context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder { //set up item layout view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)//parent.context - denotes adapter itself , root as parent
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size // return the size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) { //set data on the elements , hoder helps to set the data, position helps to detamine which item was clicked
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    //we have to keep refreshing or updating the list whenever a new note is inserted otherwise it display old data
    fun refreshData(newNotes: List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }

}