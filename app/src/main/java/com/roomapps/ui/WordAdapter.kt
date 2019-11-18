package com.roomapps.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomapps.R
import com.roomapps.database.Word
import kotlinx.android.synthetic.main.adapter_word.view.*

class WordAdapter: RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    private lateinit var listener: OnAdapterListener
    private var words = emptyList<Word>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_word, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = words[position]
        holder.itemView.tv_word.text = current.word
        holder.itemView.setOnClickListener { listener.onClick(current) }
    }

    fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    fun setOnAdapterListener(listener: OnAdapterListener){
        this.listener = listener
    }

    override fun getItemCount() = words.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnAdapterListener{
        fun onClick(word: Word)
    }
}